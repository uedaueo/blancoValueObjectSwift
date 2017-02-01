/*
 * blanco Framework
 * Copyright (C) 2004-2010 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.valueobject;

import java.io.File;
import java.io.IOException;
import java.util.List;

import blanco.beanutils.BlancoBeanUtils;
import blanco.cg.BlancoCgObjectFactory;
import blanco.cg.BlancoCgSupportedLang;
import blanco.cg.transformer.BlancoCgTransformerFactory;
import blanco.cg.valueobject.BlancoCgClass;
import blanco.cg.valueobject.BlancoCgField;
import blanco.cg.valueobject.BlancoCgMethod;
import blanco.cg.valueobject.BlancoCgSourceFile;
import blanco.commons.util.BlancoJavaSourceUtil;
import blanco.commons.util.BlancoNameAdjuster;
import blanco.commons.util.BlancoNameUtil;
import blanco.commons.util.BlancoStringUtil;
import blanco.valueobject.message.BlancoValueObjectMessage;
import blanco.valueobject.resourcebundle.BlancoValueObjectResourceBundle;
import blanco.valueobject.valueobject.BlancoValueObjectClassStructure;
import blanco.valueobject.valueobject.BlancoValueObjectFieldStructure;

/**
 * バリューオブジェクト用中間XMLファイルから Javaソースコードを自動生成するクラス。
 * 
 * blancoValueObjectの主たるクラスのひとつです。
 * 
 * @author IGA Tosiki
 */
public class BlancoValueObjectXml2Swift {
    /**
     * メッセージ。
     */
    private final BlancoValueObjectMessage fMsg = new BlancoValueObjectMessage();

    /**
     * blancoValueObjectのリソースバンドルオブジェクト。
     */
    private final BlancoValueObjectResourceBundle fBundle = new BlancoValueObjectResourceBundle();

    /**
     * 入力シートに期待するプログラミング言語
     */
    private int fSheetLang = BlancoCgSupportedLang.JAVA;

    public void setSheetLang(final int argSheetLang) {
        fSheetLang = argSheetLang;
    }

    /**
     * 内部的に利用するblancoCg用ファクトリ。
     */
    private BlancoCgObjectFactory fCgFactory = null;

    /**
     * 内部的に利用するblancoCg用ソースファイル情報。
     */
    private BlancoCgSourceFile fCgSourceFile = null;

    /**
     * 内部的に利用するblancoCg用クラス情報。
     */
    private BlancoCgClass fCgClass = null;

    /**
     * 自動生成するソースファイルの文字エンコーディング。
     */
    private String fEncoding = null;

    public void setEncoding(final String argEncoding) {
        fEncoding = argEncoding;
    }

    private boolean fIsXmlRootElement = false;

    public void setXmlRootElement(final boolean isXmlRootElement) {
        fIsXmlRootElement = isXmlRootElement;
    }

    /**
     * バリューオブジェクトを表現する中間XMLファイルから、Javaソースコードを自動生成します。
     * 
     * @param argMetaXmlSourceFile
     *            ValueObjectに関するメタ情報が含まれているXMLファイル
     * @param argDirectoryTarget
     *            ソースコード生成先ディレクトリ
     * @throws IOException
     *             入出力例外が発生した場合
     */
    public void process(final File argMetaXmlSourceFile,
            final File argDirectoryTarget) throws IOException {
        final BlancoValueObjectClassStructure[] structures = new BlancoValueObjectXmlParser()
                .parse(argMetaXmlSourceFile);
        for (int index = 0; index < structures.length; index++) {
            // 得られた情報からJavaソースコードを生成します。
            structure2Source(structures[index], argDirectoryTarget);
        }
    }

    /**
     * 与えられたクラス情報バリューオブジェクトから、ソースコードを自動生成します。
     * 
     * @param argClassStructure
     *            クラス情報
     * @param argDirectoryTarget
     *            Javaソースコードの出力先ディレクトリ
     * @throws IOException
     *             入出力例外が発生した場合。
     */
    public void structure2Source(
            final BlancoValueObjectClassStructure argClassStructure,
            final File argDirectoryTarget) throws IOException {
        // 従来と互換性を持たせるため、/mainサブフォルダに出力します。
        final File fileBlancoMain = new File(argDirectoryTarget
                .getAbsolutePath()
                + "/main");

//        /* tueda DEBUG */
//        System.out.println("/* tueda */ structure2Source : " + argClassStructure.getName());

        // BlancoCgObjectFactoryクラスのインスタンスを取得します。
        fCgFactory = BlancoCgObjectFactory.getInstance();

        fCgSourceFile = fCgFactory.createSourceFile(argClassStructure
                .getPackage(), null);
        fCgSourceFile.setEncoding(fEncoding);

        // クラスを作成します。
        fCgClass = fCgFactory.createClass(argClassStructure.getName(), "");
        fCgSourceFile.getClassList().add(fCgClass);

        // クラスのアクセスを設定。
        fCgClass.setAccess(argClassStructure.getAccess());
        // 抽象クラスかどうか。
        fCgClass.setAbstract(argClassStructure.getAbstract());

        // 継承
        if (BlancoStringUtil.null2Blank(argClassStructure.getExtends())
                .length() > 0) {
            fCgClass.getExtendClassList().add(
                    fCgFactory.createType(argClassStructure.getExtends()));
        }
        // 実装
        for (int index = 0; index < argClassStructure.getImplementsList()
                .size(); index++) {
            final String impl = (String) argClassStructure.getImplementsList()
                    .get(index);
            fCgClass.getImplementInterfaceList().add(
                    fCgFactory.createType(impl));
        }
        // superclass, interfaceがなくても、Mappableを実装する
        // TODO Mappable実装が必要かどうか判別する
        fCgClass.getImplementInterfaceList().add(
                fCgFactory.createType("ObjectMapper.Mappable"));

        if (fIsXmlRootElement) {
            fCgClass.getAnnotationList().add("XmlRootElement");
            /*fCgSourceFile.getImportList().add(
                    "javax.xml.bind.annotation.XmlRootElement");*/
        }

        // クラスのJavaDocを設定します。
        fCgClass.setDescription(argClassStructure.getDescription());
        for (String line : argClassStructure.getDescriptionList()) {
            fCgClass.getLangDoc().getDescriptionList().add(line);
        }

        for (int indexField = 0; indexField < argClassStructure.getFieldList()
                .size(); indexField++) {
            // おのおののフィールドを処理します。
            final BlancoValueObjectFieldStructure fieldStructure = (BlancoValueObjectFieldStructure) argClassStructure
                    .getFieldList().get(indexField);

            // 必須項目が未設定の場合には例外処理を実施します。
            if (fieldStructure.getName() == null) {
                throw new IllegalArgumentException(fMsg
                        .getMbvoji03(argClassStructure.getName()));
            }
            if (fieldStructure.getType() == null) {
                throw new IllegalArgumentException(fMsg.getMbvoji04(
                        argClassStructure.getName(), fieldStructure.getName()));
            }

            // フィールドの生成。
            buildField(argClassStructure, fieldStructure);

            // セッターメソッドの生成。
            buildMethodSet(argClassStructure, fieldStructure);

            // ゲッターメソッドの生成。
            buildMethodGet(argClassStructure, fieldStructure);
        }

        // init?メソッドの生成。
        // TODO Mappable実装が必要かどうか判別する
        buildMethodInit();


        // mappingメソッドの生成。
        // TODO Mappable実装が必要かどうか判別する
        buildMethodMapping(argClassStructure);

        if (argClassStructure.getGenerateToString()) {
            // toStringメソッドの生成。
            buildMethodToString(argClassStructure);
        }

        // TODO copyTo メソッドの生成有無を外部フラグ化するかどうか検討すること。
        //BlancoBeanUtils.generateCopyToMethod(fCgSourceFile, fCgClass);

        // 収集された情報を元に実際のソースコードを自動生成。
        BlancoCgTransformerFactory.getSwiftSourceTransformer().transform(
                fCgSourceFile, fileBlancoMain);
    }

    /**
     * クラスにフィールドを生成します。
     * 
     * @param argClassStructure
     *            クラス情報。
     * @param argFieldStructure
     *            フィールド情報。
     */
    private void buildField(
            final BlancoValueObjectClassStructure argClassStructure,
            final BlancoValueObjectFieldStructure argFieldStructure) {

        switch (fSheetLang) {
            case BlancoCgSupportedLang.PHP:
                if (argFieldStructure.getType() == "java.lang.Integer") argFieldStructure.setType("java.lang.Long");
                break;
            /* 対応言語を増やす場合はここに case を追記します */
        }

        final BlancoCgField field = fCgFactory.createField("f"
                + getFieldNameAdjustered(argClassStructure, argFieldStructure),
                argFieldStructure.getType(), null);
        fCgClass.getFieldList().add(field);

        // フィールドのJavaDocを設定します。
        field.setDescription(argFieldStructure.getDescription());
        for (String line : argFieldStructure.getDescriptionList()) {
            field.getLangDoc().getDescriptionList().add(line);
        }
        field.getLangDoc().getDescriptionList().add(
                fBundle.getXml2javaclassFieldName(argFieldStructure.getName()));

        if (argFieldStructure.getDefault() != null) {
            // フィールドのデフォルト値を設定します。
            field.getLangDoc().getDescriptionList().add(
                    fBundle.getXml2javaclassFieldDefault(argFieldStructure
                            .getDefault()));
            if (argClassStructure.getAdjustDefaultValue() == false) {
                // デフォルト値の変形がoffの場合には、定義書上の値をそのまま採用。
                field.setDefault(argFieldStructure.getDefault());
            } else {
                final String type = field.getType().getName();

                if (type.equals("java.lang.String")) {
                    // ダブルクオートを付与します。
                    field.setDefault("\""
                            + BlancoJavaSourceUtil
                                    .escapeStringAsJavaSource(argFieldStructure
                                            .getDefault()) + "\"");
                } else if (type.equals("boolean") || type.equals("short")
                        || type.equals("int") || type.equals("long")) {
                    field.setDefault(argFieldStructure.getDefault());
                } else if (type.equals("java.lang.Boolean")
                        || type.equals("java.lang.Integer")
                        || type.equals("java.lang.Long")) {
                    field.setDefault("new "
                            + BlancoNameUtil.trimJavaPackage(type) + "("
                            + argFieldStructure.getDefault() + ")");
                } else if (type.equals("java.lang.Short")) {
                    field.setDefault("new "
                            + BlancoNameUtil.trimJavaPackage(type)
                            + "((short) " + argFieldStructure.getDefault()
                            + ")");
                } else if (type.equals("java.math.BigDecimal")) {
                    fCgSourceFile.getImportList().add("java.math.BigDecimal");
                    // 文字列からBigDecimalへと変換します。
                    field.setDefault("new BigDecimal(\""
                            + argFieldStructure.getDefault() + "\")");
                } else if (type.equals("java.util.List")
                        || type.equals("java.util.ArrayList")) {
                    // ArrayListの場合には、与えられた文字をそのまま採用します。
                    // TODO 第2世代blancoValueObject採用場合には、全クラスインポートが妥当。
                    fCgSourceFile.getImportList().add(type);
                    field.setDefault(argFieldStructure.getDefault());
                } else {
                    throw new IllegalArgumentException(fMsg.getMbvoji05(
                            argClassStructure.getName(), argFieldStructure
                                    .getName(), argFieldStructure.getDefault(),
                            type));
                }
            }
        }
    }

    /**
     * setメソッドを生成します。
     * 
     * @param argFieldStructure
     *            フィールド情報。
     */
    private void buildMethodSet(
            final BlancoValueObjectClassStructure argClassStructure,
            final BlancoValueObjectFieldStructure argFieldStructure) {
        // おのおののフィールドに対するセッターメソッドを生成します。
        final BlancoCgMethod method = fCgFactory.createMethod("set"
                + getFieldNameAdjustered(argClassStructure, argFieldStructure),
                fBundle.getXml2javaclassSetJavadoc01(argFieldStructure
                        .getName()));
        fCgClass.getMethodList().add(method);

        // メソッドの JavaDoc設定。
        if (argFieldStructure.getDescription() != null) {
            method.getLangDoc().getDescriptionList().add(
                    fBundle.getXml2javaclassSetJavadoc02(argFieldStructure
                            .getDescription()));
        }
        for (String line : argFieldStructure.getDescriptionList()) {
            method.getLangDoc().getDescriptionList().add(line);
        }

        method.getParameterList().add(
                fCgFactory.createParameter("arg"
                        + getFieldNameAdjustered(argClassStructure,
                                argFieldStructure),
                        argFieldStructure.getType(),
                        fBundle.getXml2javaclassSetArgJavadoc(argFieldStructure
                                .getName())));

        // メソッドの実装
        method.getLineList().add(
                "f"
                        + getFieldNameAdjustered(argClassStructure,
                                argFieldStructure)
                        + " = "
                        + "arg"
                        + getFieldNameAdjustered(argClassStructure,
                                argFieldStructure) + ";");
    }

    /**
     * getメソッドを生成します。
     * 
     * @param argFieldStructure
     *            フィールド情報。
     */
    private void buildMethodGet(
            final BlancoValueObjectClassStructure argClassStructure,
            final BlancoValueObjectFieldStructure argFieldStructure) {
        // おのおののフィールドに対するゲッターメソッドを生成します。
        final BlancoCgMethod method = fCgFactory.createMethod("get"
                + getFieldNameAdjustered(argClassStructure, argFieldStructure),
                fBundle.getXml2javaclassGetJavadoc01(argFieldStructure
                        .getName()));
        fCgClass.getMethodList().add(method);

        // メソッドの JavaDoc設定。
        if (argFieldStructure.getDescription() != null) {
            method.getLangDoc().getDescriptionList().add(
                    fBundle.getXml2javaclassGetJavadoc02(argFieldStructure
                            .getDescription()));
        }
        for (String line : argFieldStructure.getDescriptionList()) {
            method.getLangDoc().getDescriptionList().add(line);
        }
        if (argFieldStructure.getDefault() != null) {
            method.getLangDoc().getDescriptionList().add(
                    fBundle.getXml2javaclassGetDefaultJavadoc(argFieldStructure
                            .getDefault()));
        }

        method.setReturn(fCgFactory.createReturn(argFieldStructure.getType(),
                fBundle.getXml2javaclassGetReturnJavadoc(argFieldStructure
                        .getName())));

        // メソッドの実装
        method.getLineList().add(
                "return f"
                        + getFieldNameAdjustered(argClassStructure,
                                argFieldStructure) + ";");
    }

    /**
     * toStringメソッドを生成します。
     * 
     * @param argClassStructure
     *            クラス情報。
     */
    private void buildMethodToString(
            final BlancoValueObjectClassStructure argClassStructure) {
        final BlancoCgMethod method = fCgFactory.createMethod("toString",
                "このバリューオブジェクトの文字列表現を取得します。");
        fCgClass.getMethodList().add(method);

        method.getLangDoc().getDescriptionList().add("<P>使用上の注意</P>");
        method.getLangDoc().getDescriptionList().add("<UL>");
        method.getLangDoc().getDescriptionList().add(
                "<LI>オブジェクトのシャロー範囲のみ文字列化の処理対象となります。");
        method.getLangDoc().getDescriptionList().add(
                "<LI>オブジェクトが循環参照している場合には、このメソッドは使わないでください。");
        method.getLangDoc().getDescriptionList().add("</UL>");
        method.setReturn(fCgFactory.createReturn("java.lang.String",
                "バリューオブジェクトの文字列表現。"));
        method.getAnnotationList().add("Override");

        final List<java.lang.String> listLine = method.getLineList();

        listLine.add("final StringBuffer buf = new StringBuffer();");
        listLine.add("buf.append(\"" + argClassStructure.getPackage() + "."
                + argClassStructure.getName() + "[\");");
        for (int indexField = 0; indexField < argClassStructure.getFieldList()
                .size(); indexField++) {
            final BlancoValueObjectFieldStructure field = (BlancoValueObjectFieldStructure) argClassStructure
                    .getFieldList().get(indexField);

            final String fieldNameAdjustered = (argClassStructure
                    .getAdjustFieldName() == false ? field.getName()
                    : BlancoNameAdjuster.toClassName(field.getName()));

            if (field.getType().endsWith("[]") == false) {
                listLine.add("buf.append(\"" + (indexField == 0 ? "" : ",")
                        + field.getName() + "=\" + f" + fieldNameAdjustered
                        + ");");
            } else {
                // 2006.05.31 t.iga 配列の場合には、先に
                // その配列自身がnullかどうかのチェックが必要です。
                listLine.add("if (f" + fieldNameAdjustered + " == null) {");
                // 0番目の項目である場合にはカンマなしの特別扱いをします。
                listLine.add("buf.append(" + (indexField == 0 ? "\"" :
                // 0番目ではない場合には、常にカンマを付与します。
                        "\",") + field.getName() + "=null\");");
                listLine.add("} else {");

                // 配列の場合にはディープにtoStringします。
                listLine.add("buf.append("
                // 0番目の項目である場合にはカンマなしの特別扱いをします。
                        + (indexField == 0 ? "\"" :
                        // 0番目ではない場合には、常にカンマを付与します。
                                "\",") + field.getName() + "=[\");");
                listLine.add("for (int index = 0; index < f"
                        + fieldNameAdjustered + ".length; index++) {");
                // 2006.05.31 t.iga
                // ArrayListなどのtoStringと同様になるように、カンマのあとに半角スペースを付与するようにします。
                listLine.add("buf.append((index == 0 ? \"\" : \", \") + f"
                        + fieldNameAdjustered + "[index]);");
                listLine.add("}");
                listLine.add("buf.append(\"]\");");
                listLine.add("}");
            }
        }
        listLine.add("buf.append(\"]\");");
        listLine.add("return buf.toString();");
    }

    /**
     * JSON→SwiftClass変換時に必要なmappingメソッドを生成します。
     *
     * @param argClassStructure
     *            クラス情報。
     */
    private void buildMethodMapping(
            final BlancoValueObjectClassStructure argClassStructure) {
        final BlancoCgMethod method = fCgFactory.createMethod("mapping",
                "JSON←→Classに変換する時にObjectMapperが使うメソッド");
        fCgClass.getMethodList().add(method);

        method.getParameterList().add(
                fCgFactory.createParameter("map", "ObjectMapper.Map", "Map"));

        final List<java.lang.String> listLine = method.getLineList();

        for (int indexField = 0; indexField < argClassStructure.getFieldList()
                .size(); indexField++) {
            final BlancoValueObjectFieldStructure field = (BlancoValueObjectFieldStructure) argClassStructure
                    .getFieldList().get(indexField);

            final String fieldNameAdjustered = (argClassStructure
                    .getAdjustFieldName() == false ? field.getName()
                    : BlancoNameAdjuster.toClassName(field.getName()));

            listLine.add("f" + fieldNameAdjustered + " <- map[\"" + fieldNameAdjustered + "\"]");
        }
    }

    /**
     * JSON→SwiftClass変換時に必要なinit?メソッドを生成します。
     */
    private void buildMethodInit() {
        final BlancoCgMethod method = fCgFactory.createMethod("init?",
                "JSON←→Classに変換する時にObjectMapperが使うメソッド");
        fCgClass.getMethodList().add(method);

        method.setAccess("required");
        method.getParameterList().add(
                fCgFactory.createParameter("map", "ObjectMapper.Map", "Map"));
    }

    /**
     * 調整済みのフィールド名を取得します。
     * 
     * @param argFieldStructure
     *            フィールド情報。
     * @return 調整後のフィールド名。
     */
    private String getFieldNameAdjustered(
            final BlancoValueObjectClassStructure argClassStructure,
            final BlancoValueObjectFieldStructure argFieldStructure) {
        return (argClassStructure.getAdjustFieldName() == false ? argFieldStructure
                .getName()
                : BlancoNameAdjuster.toClassName(argFieldStructure.getName()));
    }
}

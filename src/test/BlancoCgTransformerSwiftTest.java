/*
 * blanco Framework
 * Copyright (C) 2004-2006 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package test;

import java.io.File;

import blanco.cg.BlancoCgObjectFactory;
import blanco.cg.BlancoCgTransformer;
import junit.framework.TestCase;
import blanco.cg.transformer.BlancoCgTransformerFactory;
import blanco.cg.valueobject.BlancoCgClass;
import blanco.cg.valueobject.BlancoCgEnum;
import blanco.cg.valueobject.BlancoCgEnumElement;
import blanco.cg.valueobject.BlancoCgField;
import blanco.cg.valueobject.BlancoCgInterface;
import blanco.cg.valueobject.BlancoCgMethod;
import blanco.cg.valueobject.BlancoCgSourceFile;

/**
 * Swift言語用の生成試験。
 * 
 * @author IGA Tosiki
 */
public class BlancoCgTransformerSwiftTest extends TestCase {
    /**
     * Swiftの試験。
     * 
     * @throws Exception
     */
    public void testTransformerSwift() throws Exception {
        final BlancoCgObjectFactory cgFactory = BlancoCgObjectFactory
                .getInstance();

        // ソースファイルを生成します。
        final BlancoCgSourceFile cgSourceFile = cgFactory.createSourceFile(
                "Myprog", "テスト用のクラス");
//        cgSourceFile.getImportList().add("Foundation");

        // クラスを生成します。
        final BlancoCgClass cgClass = cgFactory.createClass("MyClass",
                "このクラスは、テストのためのクラスです。");
        cgSourceFile.getClassList().add(cgClass);
        cgClass.getLangDoc().getTagList().add(
                cgFactory.createLangDocTag("author", null, "blanco Framework"));
        cgClass.getExtendClassList().add(
                cgFactory.createType("Foundation.Thread"));
        cgClass.getImplementInterfaceList().add(
                cgFactory.createType("Foundation.WebException"));
        cgClass.getImplementInterfaceList().add(
                cgFactory.createType("Foundation.WebException2"));

if(false){
        // 列挙体
        final BlancoCgEnum cgEnum = cgFactory.createEnum("FavorColor",
                "列挙体の試験。");
        cgClass.getEnumList().add(cgEnum);
        final BlancoCgEnumElement cgEnumElementFirst = cgFactory
                .createEnumElement("Red", "あか");
        cgEnumElementFirst.setDefault("1");
        cgEnum.getElementList().add(cgEnumElementFirst);
        cgEnum.getElementList().add(
                cgFactory.createEnumElement("Yerrow", "きいろ"));
        cgEnum.getElementList().add(cgFactory.createEnumElement("Blue", "あお"));
}

        // フィールドを生成します。
        final BlancoCgField cgField = cgFactory.createField("myField",
                "Foundation.Date", "日付フィールドの試験です。");
        cgClass.getFieldList().add(cgField);
        cgField.setDefault("DateTime()");

        final BlancoCgField cgField2 = cgFactory.createField("myField2",
                "Foundation.Integer", "intフィールドの試験です。");
        cgClass.getFieldList().add(cgField2);

        // メソッドを生成します。
        final BlancoCgMethod cgMethod = cgFactory.createMethod("MyMethod",
                "メソッドの試験です。");
        cgClass.getMethodList().add(cgMethod);

        // パラメータを追加します。
        cgMethod.getParameterList().add(
                cgFactory.createParameter("argString", "Foundation.String",
                        "文字列引数。"));
        cgMethod.getParameterList()
                .add(
                        cgFactory.createParameter("argDate", "Foundation.DateTime",
                                "日付引数。"));
        // 戻り値を設定します。
        cgMethod.setReturn(cgFactory.createReturn("Foundation.Boolean", "成功ならtrue。"));

        cgMethod.getThrowList().add(
                cgFactory.createException("Foundation.IOException",
                        "入出力例外が発生した場合。"));

        // アノテーションの追加。
 // TODO      cgMethod.getAnnotationList().add(
 //               "Copyright(value=\"blanco Framework\")");

        // メソッドの内容を追加します。
        cgMethod.getLineList().add("// 代入の試験です。");
        cgMethod.getLineList().add("let a = 0;");

        final BlancoCgTransformer cgTransformerSwift = BlancoCgTransformerFactory
                .getSwiftSourceTransformer();
        cgTransformerSwift.transform(cgSourceFile, new File("./tmp/blanco"));
    }

    /**
     * インタフェースの展開試験。
     * 
     * @throws Exception
     */
    public void testTransformerInterface() throws Exception {
        final BlancoCgObjectFactory cgOf = BlancoCgObjectFactory.getInstance();

        // ソースファイルを生成します。
        final BlancoCgSourceFile cgSourceFile = cgOf.createSourceFile("Myprog",
                "テスト用のインタフェース");
        cgSourceFile.getImportList().add("Myprog.Class2");
        cgSourceFile.getImportList().add("Myprog2.ClassOther");

        // クラスを生成します。
        final BlancoCgInterface cgInterface = cgOf.createInterface(
                "MyInterface", "このインタフェースは、テストのためのインタフェースです。");
        cgSourceFile.getInterfaceList().add(cgInterface);
        cgInterface.getLangDoc().getTagList().add(
                cgOf.createLangDocTag("author", null, "blanco Framework"));
        cgInterface.getExtendClassList().add(
                cgOf.createType("System.IO.IOException"));

        // フィールドを生成します。
        final BlancoCgField cgField = cgOf.createField("myField",
                "System.DateTime", "日付フィールドの試験です。");
        cgInterface.getFieldList().add(cgField);
        cgField.setDefault("new DateTime()");

        // メソッドを生成します。
        final BlancoCgMethod cgMethod = cgOf.createMethod("MyMethod",
                "メソッドの試験です。");
        cgInterface.getMethodList().add(cgMethod);

        // パラメータを追加します。
        cgMethod.getParameterList().add(
                cgOf.createParameter("argString", "System.String", "文字列引数。"));
        cgMethod.getParameterList().add(
                cgOf.createParameter("argDate", "System.DateTime", "日付引数。"));
        // 戻り値を設定します。
        cgMethod.setReturn(cgOf.createReturn("bool", "成功ならtrue。"));

        cgMethod.getThrowList().add(
                cgOf.createException("System.IO.IOException", "入出力例外が発生した場合。"));

        final BlancoCgTransformer cgTransformerSwift = BlancoCgTransformerFactory
                .getSwiftSourceTransformer();
        cgTransformerSwift.transform(cgSourceFile, new File("./tmp/blanco"));
    }
}

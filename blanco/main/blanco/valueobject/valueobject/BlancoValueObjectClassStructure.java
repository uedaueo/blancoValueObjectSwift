/*
 * このソースコードは blanco Frameworkにより自動生成されました。
 */
package blanco.valueobject.valueobject;

import java.util.List;

/**
 * バリューオブジェクトのクラスをあらわすバリューオブジェクトクラス。このクラスの設定情報をもとにクラスが自動生成されます。
 */
public class BlancoValueObjectClassStructure {
    /**
     * フィールド名を指定します。必須項目です。
     *
     * フィールド: [name]。
     */
    private String fName;

    /**
     * パッケージ名を指定します。必須項目です。
     *
     * フィールド: [package]。
     */
    private String fPackage;

    /**
     * クラスの説明です。
     *
     * フィールド: [description]。
     */
    private String fDescription;

    /**
     * クラスの補助説明です。文字参照エンコード済みの値を格納してください。
     *
     * フィールド: [descriptionList]。
     * デフォルト: [new java.util.ArrayList<java.lang.String>()]。
     */
    private List<java.lang.String> fDescriptionList = new java.util.ArrayList<java.lang.String>();

    /**
     * クラスのアクセス。通常は public。
     *
     * フィールド: [access]。
     * デフォルト: ["public"]。
     */
    private String fAccess = "public";

    /**
     * 抽象クラスかどうか。通常は false。
     *
     * フィールド: [abstract]。
     * デフォルト: [false]。
     */
    private boolean fAbstract = false;

    /**
     * toStringメソッドを生成するかどうか。
     *
     * フィールド: [generateToString]。
     * デフォルト: [true]。
     */
    private boolean fGenerateToString = true;

    /**
     * フィールド名の名前変形をおこなうかどうか。
     *
     * フィールド: [adjustFieldName]。
     * デフォルト: [true]。
     */
    private boolean fAdjustFieldName = true;

    /**
     * デフォルト値の変形をおこなうかどうか。※なるべく変形を利用しないことを推奨したい。※プログラムAPIとして生成する際には、このフィールドを明示的に設定してください。
     *
     * フィールド: [adjustDefaultValue]。
     * デフォルト: [true]。
     */
    private boolean fAdjustDefaultValue = true;

    /**
     * 継承するクラスを指定します。
     *
     * フィールド: [extends]。
     */
    private String fExtends;

    /**
     * 実装するインタフェース(java.lang.String)の一覧。
     *
     * フィールド: [implementsList]。
     * デフォルト: [new java.util.ArrayList<java.lang.String>()]。
     */
    private List<java.lang.String> fImplementsList = new java.util.ArrayList<java.lang.String>();

    /**
     * フィールドを記憶するリストを指定します。
     *
     * フィールド: [fieldList]。
     * デフォルト: [new java.util.ArrayList<blanco.valueobject.valueobject.BlancoValueObjectFieldStructure>()]。
     */
    private List<blanco.valueobject.valueobject.BlancoValueObjectFieldStructure> fFieldList = new java.util.ArrayList<blanco.valueobject.valueobject.BlancoValueObjectFieldStructure>();

    /**
     * ファイル説明
     *
     * フィールド: [fileDescription]。
     */
    private String fFileDescription;

    /**
     * フィールド [name] の値を設定します。
     *
     * フィールドの説明: [フィールド名を指定します。必須項目です。]。
     *
     * @param argName フィールド[name]に設定する値。
     */
    public void setName(final String argName) {
        fName = argName;
    }

    /**
     * フィールド [name] の値を取得します。
     *
     * フィールドの説明: [フィールド名を指定します。必須項目です。]。
     *
     * @return フィールド[name]から取得した値。
     */
    public String getName() {
        return fName;
    }

    /**
     * フィールド [package] の値を設定します。
     *
     * フィールドの説明: [パッケージ名を指定します。必須項目です。]。
     *
     * @param argPackage フィールド[package]に設定する値。
     */
    public void setPackage(final String argPackage) {
        fPackage = argPackage;
    }

    /**
     * フィールド [package] の値を取得します。
     *
     * フィールドの説明: [パッケージ名を指定します。必須項目です。]。
     *
     * @return フィールド[package]から取得した値。
     */
    public String getPackage() {
        return fPackage;
    }

    /**
     * フィールド [description] の値を設定します。
     *
     * フィールドの説明: [クラスの説明です。]。
     *
     * @param argDescription フィールド[description]に設定する値。
     */
    public void setDescription(final String argDescription) {
        fDescription = argDescription;
    }

    /**
     * フィールド [description] の値を取得します。
     *
     * フィールドの説明: [クラスの説明です。]。
     *
     * @return フィールド[description]から取得した値。
     */
    public String getDescription() {
        return fDescription;
    }

    /**
     * フィールド [descriptionList] の値を設定します。
     *
     * フィールドの説明: [クラスの補助説明です。文字参照エンコード済みの値を格納してください。]。
     *
     * @param argDescriptionList フィールド[descriptionList]に設定する値。
     */
    public void setDescriptionList(final List<java.lang.String> argDescriptionList) {
        fDescriptionList = argDescriptionList;
    }

    /**
     * フィールド [descriptionList] の値を取得します。
     *
     * フィールドの説明: [クラスの補助説明です。文字参照エンコード済みの値を格納してください。]。
     * デフォルト: [new java.util.ArrayList<java.lang.String>()]。
     *
     * @return フィールド[descriptionList]から取得した値。
     */
    public List<java.lang.String> getDescriptionList() {
        return fDescriptionList;
    }

    /**
     * フィールド [access] の値を設定します。
     *
     * フィールドの説明: [クラスのアクセス。通常は public。]。
     *
     * @param argAccess フィールド[access]に設定する値。
     */
    public void setAccess(final String argAccess) {
        fAccess = argAccess;
    }

    /**
     * フィールド [access] の値を取得します。
     *
     * フィールドの説明: [クラスのアクセス。通常は public。]。
     * デフォルト: ["public"]。
     *
     * @return フィールド[access]から取得した値。
     */
    public String getAccess() {
        return fAccess;
    }

    /**
     * フィールド [abstract] の値を設定します。
     *
     * フィールドの説明: [抽象クラスかどうか。通常は false。]。
     *
     * @param argAbstract フィールド[abstract]に設定する値。
     */
    public void setAbstract(final boolean argAbstract) {
        fAbstract = argAbstract;
    }

    /**
     * フィールド [abstract] の値を取得します。
     *
     * フィールドの説明: [抽象クラスかどうか。通常は false。]。
     * デフォルト: [false]。
     *
     * @return フィールド[abstract]から取得した値。
     */
    public boolean getAbstract() {
        return fAbstract;
    }

    /**
     * フィールド [generateToString] の値を設定します。
     *
     * フィールドの説明: [toStringメソッドを生成するかどうか。]。
     *
     * @param argGenerateToString フィールド[generateToString]に設定する値。
     */
    public void setGenerateToString(final boolean argGenerateToString) {
        fGenerateToString = argGenerateToString;
    }

    /**
     * フィールド [generateToString] の値を取得します。
     *
     * フィールドの説明: [toStringメソッドを生成するかどうか。]。
     * デフォルト: [true]。
     *
     * @return フィールド[generateToString]から取得した値。
     */
    public boolean getGenerateToString() {
        return fGenerateToString;
    }

    /**
     * フィールド [adjustFieldName] の値を設定します。
     *
     * フィールドの説明: [フィールド名の名前変形をおこなうかどうか。]。
     *
     * @param argAdjustFieldName フィールド[adjustFieldName]に設定する値。
     */
    public void setAdjustFieldName(final boolean argAdjustFieldName) {
        fAdjustFieldName = argAdjustFieldName;
    }

    /**
     * フィールド [adjustFieldName] の値を取得します。
     *
     * フィールドの説明: [フィールド名の名前変形をおこなうかどうか。]。
     * デフォルト: [true]。
     *
     * @return フィールド[adjustFieldName]から取得した値。
     */
    public boolean getAdjustFieldName() {
        return fAdjustFieldName;
    }

    /**
     * フィールド [adjustDefaultValue] の値を設定します。
     *
     * フィールドの説明: [デフォルト値の変形をおこなうかどうか。※なるべく変形を利用しないことを推奨したい。※プログラムAPIとして生成する際には、このフィールドを明示的に設定してください。]。
     *
     * @param argAdjustDefaultValue フィールド[adjustDefaultValue]に設定する値。
     */
    public void setAdjustDefaultValue(final boolean argAdjustDefaultValue) {
        fAdjustDefaultValue = argAdjustDefaultValue;
    }

    /**
     * フィールド [adjustDefaultValue] の値を取得します。
     *
     * フィールドの説明: [デフォルト値の変形をおこなうかどうか。※なるべく変形を利用しないことを推奨したい。※プログラムAPIとして生成する際には、このフィールドを明示的に設定してください。]。
     * デフォルト: [true]。
     *
     * @return フィールド[adjustDefaultValue]から取得した値。
     */
    public boolean getAdjustDefaultValue() {
        return fAdjustDefaultValue;
    }

    /**
     * フィールド [extends] の値を設定します。
     *
     * フィールドの説明: [継承するクラスを指定します。]。
     *
     * @param argExtends フィールド[extends]に設定する値。
     */
    public void setExtends(final String argExtends) {
        fExtends = argExtends;
    }

    /**
     * フィールド [extends] の値を取得します。
     *
     * フィールドの説明: [継承するクラスを指定します。]。
     *
     * @return フィールド[extends]から取得した値。
     */
    public String getExtends() {
        return fExtends;
    }

    /**
     * フィールド [implementsList] の値を設定します。
     *
     * フィールドの説明: [実装するインタフェース(java.lang.String)の一覧。]。
     *
     * @param argImplementsList フィールド[implementsList]に設定する値。
     */
    public void setImplementsList(final List<java.lang.String> argImplementsList) {
        fImplementsList = argImplementsList;
    }

    /**
     * フィールド [implementsList] の値を取得します。
     *
     * フィールドの説明: [実装するインタフェース(java.lang.String)の一覧。]。
     * デフォルト: [new java.util.ArrayList<java.lang.String>()]。
     *
     * @return フィールド[implementsList]から取得した値。
     */
    public List<java.lang.String> getImplementsList() {
        return fImplementsList;
    }

    /**
     * フィールド [fieldList] の値を設定します。
     *
     * フィールドの説明: [フィールドを記憶するリストを指定します。]。
     *
     * @param argFieldList フィールド[fieldList]に設定する値。
     */
    public void setFieldList(final List<blanco.valueobject.valueobject.BlancoValueObjectFieldStructure> argFieldList) {
        fFieldList = argFieldList;
    }

    /**
     * フィールド [fieldList] の値を取得します。
     *
     * フィールドの説明: [フィールドを記憶するリストを指定します。]。
     * デフォルト: [new java.util.ArrayList<blanco.valueobject.valueobject.BlancoValueObjectFieldStructure>()]。
     *
     * @return フィールド[fieldList]から取得した値。
     */
    public List<blanco.valueobject.valueobject.BlancoValueObjectFieldStructure> getFieldList() {
        return fFieldList;
    }

    /**
     * フィールド [fileDescription] の値を設定します。
     *
     * フィールドの説明: [ファイル説明]。
     *
     * @param argFileDescription フィールド[fileDescription]に設定する値。
     */
    public void setFileDescription(final String argFileDescription) {
        fFileDescription = argFileDescription;
    }

    /**
     * フィールド [fileDescription] の値を取得します。
     *
     * フィールドの説明: [ファイル説明]。
     *
     * @return フィールド[fileDescription]から取得した値。
     */
    public String getFileDescription() {
        return fFileDescription;
    }

    /**
     * このバリューオブジェクトの文字列表現を取得します。
     *
     * <P>使用上の注意</P>
     * <UL>
     * <LI>オブジェクトのシャロー範囲のみ文字列化の処理対象となります。
     * <LI>オブジェクトが循環参照している場合には、このメソッドは使わないでください。
     * </UL>
     *
     * @return バリューオブジェクトの文字列表現。
     */
    @Override
    public String toString() {
        final StringBuffer buf = new StringBuffer();
        buf.append("blanco.valueobject.valueobject.BlancoValueObjectClassStructure[");
        buf.append("name=" + fName);
        buf.append(",package=" + fPackage);
        buf.append(",description=" + fDescription);
        buf.append(",descriptionList=" + fDescriptionList);
        buf.append(",access=" + fAccess);
        buf.append(",abstract=" + fAbstract);
        buf.append(",generateToString=" + fGenerateToString);
        buf.append(",adjustFieldName=" + fAdjustFieldName);
        buf.append(",adjustDefaultValue=" + fAdjustDefaultValue);
        buf.append(",extends=" + fExtends);
        buf.append(",implementsList=" + fImplementsList);
        buf.append(",fieldList=" + fFieldList);
        buf.append(",fileDescription=" + fFileDescription);
        buf.append("]");
        return buf.toString();
    }

    /**
     * このバリューオブジェクトを指定のターゲットに複写します。
     *
     * <P>使用上の注意</P>
     * <UL>
     * <LI>オブジェクトのシャロー範囲のみ複写処理対象となります。
     * <LI>オブジェクトが循環参照している場合には、このメソッドは使わないでください。
     * </UL>
     *
     * @param target target value object.
     */
    public void copyTo(final BlancoValueObjectClassStructure target) {
        if (target == null) {
            throw new IllegalArgumentException("Bug: BlancoValueObjectClassStructure#copyTo(target): argument 'target' is null");
        }

        // No needs to copy parent class.

        // Name: fName
        // Type: java.lang.String
        target.fName = this.fName;
        // Name: fPackage
        // Type: java.lang.String
        target.fPackage = this.fPackage;
        // Name: fDescription
        // Type: java.lang.String
        target.fDescription = this.fDescription;
        // Name: fDescriptionList
        // Type: java.util.List
        // フィールド[fDescriptionList]はサポート外の型[java.util.List]です。
        // Name: fAccess
        // Type: java.lang.String
        target.fAccess = this.fAccess;
        // Name: fAbstract
        // Type: boolean
        target.fAbstract = this.fAbstract;
        // Name: fGenerateToString
        // Type: boolean
        target.fGenerateToString = this.fGenerateToString;
        // Name: fAdjustFieldName
        // Type: boolean
        target.fAdjustFieldName = this.fAdjustFieldName;
        // Name: fAdjustDefaultValue
        // Type: boolean
        target.fAdjustDefaultValue = this.fAdjustDefaultValue;
        // Name: fExtends
        // Type: java.lang.String
        target.fExtends = this.fExtends;
        // Name: fImplementsList
        // Type: java.util.List
        // フィールド[fImplementsList]はサポート外の型[java.util.List]です。
        // Name: fFieldList
        // Type: java.util.List
        // フィールド[fFieldList]はサポート外の型[java.util.List]です。
        // Name: fFileDescription
        // Type: java.lang.String
        target.fFileDescription = this.fFileDescription;
    }
}

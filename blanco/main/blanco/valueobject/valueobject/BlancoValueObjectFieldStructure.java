/*
 * このソースコードは blanco Frameworkにより自動生成されました。
 */
package blanco.valueobject.valueobject;

import java.util.List;

/**
 * バリューオブジェクトのフィールドをあらわすバリューオブジェクトクラス。このクラスの設定情報をもとにフィールドとセッター・ゲッターが自動生成されます。
 */
public class BlancoValueObjectFieldStructure {
    /**
     * 項目番号。省略可能です。
     *
     * フィールド: [no]。
     */
    private String fNo;

    /**
     * フィールド名を指定します。必須項目です。
     *
     * フィールド: [name]。
     */
    private String fName;

    /**
     * 型名をパッケージ名のフル修飾付で指定します。必須項目です。
     *
     * フィールド: [type]。
     */
    private String fType;

    /**
     * 型が期待する総称型の具体的な型名を指定します．
     *
     * フィールド: [generic]。
     */
    private String fGeneric;

    /**
     * デフォルト値を指定します。
     *
     * フィールド: [default]。
     */
    private String fDefault;

    /**
     * フィールドの説明です。
     *
     * フィールド: [description]。
     */
    private String fDescription;

    /**
     * フィールドの補助説明です。文字参照エンコード済みの値を格納してください。
     *
     * フィールド: [descriptionList]。
     * デフォルト: [new java.util.ArrayList<java.lang.String>()]。
     */
    private List<java.lang.String> fDescriptionList = new java.util.ArrayList<java.lang.String>();

    /**
     * (JavaDocへの反映のみ)正規表現を指定します。
     *
     * フィールド: [pattern]。
     */
    private String fPattern;

    /**
     * (JavaDocへの反映のみ)最小の長さを指定します。
     *
     * フィールド: [minLength]。
     */
    private String fMinLength;

    /**
     * (JavaDocへの反映のみ)最大の長さを指定します。
     *
     * フィールド: [maxLength]。
     */
    private String fMaxLength;

    /**
     * (JavaDocへの反映のみ)長さを指定します。
     *
     * フィールド: [length]。
     */
    private String fLength;

    /**
     * (JavaDocへの反映のみ)最小値を指定します。
     *
     * フィールド: [minInclusive]。
     */
    private String fMinInclusive;

    /**
     * (JavaDocへの反映のみ)最大値を指定します。
     *
     * フィールド: [maxInclusive]。
     */
    private String fMaxInclusive;

    /**
     * フィールド [no] の値を設定します。
     *
     * フィールドの説明: [項目番号。省略可能です。]。
     *
     * @param argNo フィールド[no]に設定する値。
     */
    public void setNo(final String argNo) {
        fNo = argNo;
    }

    /**
     * フィールド [no] の値を取得します。
     *
     * フィールドの説明: [項目番号。省略可能です。]。
     *
     * @return フィールド[no]から取得した値。
     */
    public String getNo() {
        return fNo;
    }

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
     * フィールド [type] の値を設定します。
     *
     * フィールドの説明: [型名をパッケージ名のフル修飾付で指定します。必須項目です。]。
     *
     * @param argType フィールド[type]に設定する値。
     */
    public void setType(final String argType) {
        fType = argType;
    }

    /**
     * フィールド [type] の値を取得します。
     *
     * フィールドの説明: [型名をパッケージ名のフル修飾付で指定します。必須項目です。]。
     *
     * @return フィールド[type]から取得した値。
     */
    public String getType() {
        return fType;
    }

    /**
     * フィールド [generic] の値を設定します。
     *
     * フィールドの説明: [型が期待する総称型の具体的な型名を指定します．]。
     *
     * @param argGeneric フィールド[generic]に設定する値。
     */
    public void setGeneric(final String argGeneric) {
        fGeneric = argGeneric;
    }

    /**
     * フィールド [generic] の値を取得します。
     *
     * フィールドの説明: [型が期待する総称型の具体的な型名を指定します．]。
     *
     * @return フィールド[generic]から取得した値。
     */
    public String getGeneric() {
        return fGeneric;
    }

    /**
     * フィールド [default] の値を設定します。
     *
     * フィールドの説明: [デフォルト値を指定します。]。
     *
     * @param argDefault フィールド[default]に設定する値。
     */
    public void setDefault(final String argDefault) {
        fDefault = argDefault;
    }

    /**
     * フィールド [default] の値を取得します。
     *
     * フィールドの説明: [デフォルト値を指定します。]。
     *
     * @return フィールド[default]から取得した値。
     */
    public String getDefault() {
        return fDefault;
    }

    /**
     * フィールド [description] の値を設定します。
     *
     * フィールドの説明: [フィールドの説明です。]。
     *
     * @param argDescription フィールド[description]に設定する値。
     */
    public void setDescription(final String argDescription) {
        fDescription = argDescription;
    }

    /**
     * フィールド [description] の値を取得します。
     *
     * フィールドの説明: [フィールドの説明です。]。
     *
     * @return フィールド[description]から取得した値。
     */
    public String getDescription() {
        return fDescription;
    }

    /**
     * フィールド [descriptionList] の値を設定します。
     *
     * フィールドの説明: [フィールドの補助説明です。文字参照エンコード済みの値を格納してください。]。
     *
     * @param argDescriptionList フィールド[descriptionList]に設定する値。
     */
    public void setDescriptionList(final List<java.lang.String> argDescriptionList) {
        fDescriptionList = argDescriptionList;
    }

    /**
     * フィールド [descriptionList] の値を取得します。
     *
     * フィールドの説明: [フィールドの補助説明です。文字参照エンコード済みの値を格納してください。]。
     * デフォルト: [new java.util.ArrayList<java.lang.String>()]。
     *
     * @return フィールド[descriptionList]から取得した値。
     */
    public List<java.lang.String> getDescriptionList() {
        return fDescriptionList;
    }

    /**
     * フィールド [pattern] の値を設定します。
     *
     * フィールドの説明: [(JavaDocへの反映のみ)正規表現を指定します。]。
     *
     * @param argPattern フィールド[pattern]に設定する値。
     */
    public void setPattern(final String argPattern) {
        fPattern = argPattern;
    }

    /**
     * フィールド [pattern] の値を取得します。
     *
     * フィールドの説明: [(JavaDocへの反映のみ)正規表現を指定します。]。
     *
     * @return フィールド[pattern]から取得した値。
     */
    public String getPattern() {
        return fPattern;
    }

    /**
     * フィールド [minLength] の値を設定します。
     *
     * フィールドの説明: [(JavaDocへの反映のみ)最小の長さを指定します。]。
     *
     * @param argMinLength フィールド[minLength]に設定する値。
     */
    public void setMinLength(final String argMinLength) {
        fMinLength = argMinLength;
    }

    /**
     * フィールド [minLength] の値を取得します。
     *
     * フィールドの説明: [(JavaDocへの反映のみ)最小の長さを指定します。]。
     *
     * @return フィールド[minLength]から取得した値。
     */
    public String getMinLength() {
        return fMinLength;
    }

    /**
     * フィールド [maxLength] の値を設定します。
     *
     * フィールドの説明: [(JavaDocへの反映のみ)最大の長さを指定します。]。
     *
     * @param argMaxLength フィールド[maxLength]に設定する値。
     */
    public void setMaxLength(final String argMaxLength) {
        fMaxLength = argMaxLength;
    }

    /**
     * フィールド [maxLength] の値を取得します。
     *
     * フィールドの説明: [(JavaDocへの反映のみ)最大の長さを指定します。]。
     *
     * @return フィールド[maxLength]から取得した値。
     */
    public String getMaxLength() {
        return fMaxLength;
    }

    /**
     * フィールド [length] の値を設定します。
     *
     * フィールドの説明: [(JavaDocへの反映のみ)長さを指定します。]。
     *
     * @param argLength フィールド[length]に設定する値。
     */
    public void setLength(final String argLength) {
        fLength = argLength;
    }

    /**
     * フィールド [length] の値を取得します。
     *
     * フィールドの説明: [(JavaDocへの反映のみ)長さを指定します。]。
     *
     * @return フィールド[length]から取得した値。
     */
    public String getLength() {
        return fLength;
    }

    /**
     * フィールド [minInclusive] の値を設定します。
     *
     * フィールドの説明: [(JavaDocへの反映のみ)最小値を指定します。]。
     *
     * @param argMinInclusive フィールド[minInclusive]に設定する値。
     */
    public void setMinInclusive(final String argMinInclusive) {
        fMinInclusive = argMinInclusive;
    }

    /**
     * フィールド [minInclusive] の値を取得します。
     *
     * フィールドの説明: [(JavaDocへの反映のみ)最小値を指定します。]。
     *
     * @return フィールド[minInclusive]から取得した値。
     */
    public String getMinInclusive() {
        return fMinInclusive;
    }

    /**
     * フィールド [maxInclusive] の値を設定します。
     *
     * フィールドの説明: [(JavaDocへの反映のみ)最大値を指定します。]。
     *
     * @param argMaxInclusive フィールド[maxInclusive]に設定する値。
     */
    public void setMaxInclusive(final String argMaxInclusive) {
        fMaxInclusive = argMaxInclusive;
    }

    /**
     * フィールド [maxInclusive] の値を取得します。
     *
     * フィールドの説明: [(JavaDocへの反映のみ)最大値を指定します。]。
     *
     * @return フィールド[maxInclusive]から取得した値。
     */
    public String getMaxInclusive() {
        return fMaxInclusive;
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
        buf.append("blanco.valueobject.valueobject.BlancoValueObjectFieldStructure[");
        buf.append("no=" + fNo);
        buf.append(",name=" + fName);
        buf.append(",type=" + fType);
        buf.append(",generic=" + fGeneric);
        buf.append(",default=" + fDefault);
        buf.append(",description=" + fDescription);
        buf.append(",descriptionList=" + fDescriptionList);
        buf.append(",pattern=" + fPattern);
        buf.append(",minLength=" + fMinLength);
        buf.append(",maxLength=" + fMaxLength);
        buf.append(",length=" + fLength);
        buf.append(",minInclusive=" + fMinInclusive);
        buf.append(",maxInclusive=" + fMaxInclusive);
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
    public void copyTo(final BlancoValueObjectFieldStructure target) {
        if (target == null) {
            throw new IllegalArgumentException("Bug: BlancoValueObjectFieldStructure#copyTo(target): argument 'target' is null");
        }

        // No needs to copy parent class.

        // Name: fNo
        // Type: java.lang.String
        target.fNo = this.fNo;
        // Name: fName
        // Type: java.lang.String
        target.fName = this.fName;
        // Name: fType
        // Type: java.lang.String
        target.fType = this.fType;
        // Name: fGeneric
        // Type: java.lang.String
        target.fGeneric = this.fGeneric;
        // Name: fDefault
        // Type: java.lang.String
        target.fDefault = this.fDefault;
        // Name: fDescription
        // Type: java.lang.String
        target.fDescription = this.fDescription;
        // Name: fDescriptionList
        // Type: java.util.List
        // フィールド[fDescriptionList]はサポート外の型[java.util.List]です。
        // Name: fPattern
        // Type: java.lang.String
        target.fPattern = this.fPattern;
        // Name: fMinLength
        // Type: java.lang.String
        target.fMinLength = this.fMinLength;
        // Name: fMaxLength
        // Type: java.lang.String
        target.fMaxLength = this.fMaxLength;
        // Name: fLength
        // Type: java.lang.String
        target.fLength = this.fLength;
        // Name: fMinInclusive
        // Type: java.lang.String
        target.fMinInclusive = this.fMinInclusive;
        // Name: fMaxInclusive
        // Type: java.lang.String
        target.fMaxInclusive = this.fMaxInclusive;
    }
}

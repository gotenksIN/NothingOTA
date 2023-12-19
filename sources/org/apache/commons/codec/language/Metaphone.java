package org.apache.commons.codec.language;

import androidx.appcompat.R;
import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/* loaded from: classes2.dex */
public class Metaphone implements StringEncoder {
    private static final String FRONTV = "EIY";
    private static final String VARSON = "CSPTG";
    private static final String VOWELS = "AEIOU";
    private int maxCodeLen = 4;

    private boolean isLastChar(int i, int i2) {
        return i2 + 1 == i;
    }

    public String metaphone(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        if (str.length() == 1) {
            return str.toUpperCase(Locale.ENGLISH);
        }
        char[] charArray = str.toUpperCase(Locale.ENGLISH).toCharArray();
        StringBuffer stringBuffer = new StringBuffer(40);
        StringBuffer stringBuffer2 = new StringBuffer(10);
        int i = 0;
        char c = charArray[0];
        if (c != 'A') {
            if (c == 'G' || c == 'K' || c == 'P') {
                if (charArray[1] == 'N') {
                    stringBuffer.append(charArray, 1, charArray.length - 1);
                } else {
                    stringBuffer.append(charArray);
                }
            } else if (c == 'W') {
                char c2 = charArray[1];
                if (c2 == 'R') {
                    stringBuffer.append(charArray, 1, charArray.length - 1);
                } else if (c2 == 'H') {
                    stringBuffer.append(charArray, 1, charArray.length - 1);
                    stringBuffer.setCharAt(0, 'W');
                } else {
                    stringBuffer.append(charArray);
                }
            } else if (c == 'X') {
                charArray[0] = 'S';
                stringBuffer.append(charArray);
            } else {
                stringBuffer.append(charArray);
            }
        } else if (charArray[1] == 'E') {
            stringBuffer.append(charArray, 1, charArray.length - 1);
        } else {
            stringBuffer.append(charArray);
        }
        int length = stringBuffer.length();
        while (stringBuffer2.length() < getMaxCodeLen() && i < length) {
            char charAt = stringBuffer.charAt(i);
            if (charAt == 'C' || !isPreviousChar(stringBuffer, i, charAt)) {
                switch (charAt) {
                    case R.styleable.AppCompatTheme_dividerVertical /* 65 */:
                    case R.styleable.AppCompatTheme_editTextColor /* 69 */:
                    case R.styleable.AppCompatTheme_listChoiceBackgroundIndicator /* 73 */:
                    case R.styleable.AppCompatTheme_listPreferredItemHeight /* 79 */:
                    case R.styleable.AppCompatTheme_listPreferredItemPaddingStart /* 85 */:
                        if (i == 0) {
                            stringBuffer2.append(charAt);
                            break;
                        }
                        break;
                    case R.styleable.AppCompatTheme_dropDownListViewStyle /* 66 */:
                        if (!isPreviousChar(stringBuffer, i, 'M') || !isLastChar(length, i)) {
                            stringBuffer2.append(charAt);
                            break;
                        }
                        break;
                    case R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /* 67 */:
                        if (!isPreviousChar(stringBuffer, i, 'S') || isLastChar(length, i) || FRONTV.indexOf(stringBuffer.charAt(i + 1)) < 0) {
                            if (regionMatch(stringBuffer, i, "CIA")) {
                                stringBuffer2.append('X');
                                break;
                            } else if (!isLastChar(length, i) && FRONTV.indexOf(stringBuffer.charAt(i + 1)) >= 0) {
                                stringBuffer2.append('S');
                                break;
                            } else if (isPreviousChar(stringBuffer, i, 'S') && isNextChar(stringBuffer, i, 'H')) {
                                stringBuffer2.append('K');
                                break;
                            } else if (isNextChar(stringBuffer, i, 'H')) {
                                if (i == 0 && length >= 3 && isVowel(stringBuffer, 2)) {
                                    stringBuffer2.append('K');
                                    break;
                                } else {
                                    stringBuffer2.append('X');
                                    break;
                                }
                            } else {
                                stringBuffer2.append('K');
                                break;
                            }
                        }
                        break;
                    case R.styleable.AppCompatTheme_editTextBackground /* 68 */:
                        if (!isLastChar(length, i + 1) && isNextChar(stringBuffer, i, 'G')) {
                            int i2 = i + 2;
                            if (FRONTV.indexOf(stringBuffer.charAt(i2)) >= 0) {
                                stringBuffer2.append('J');
                                i = i2;
                                break;
                            }
                        }
                        stringBuffer2.append('T');
                        break;
                    case R.styleable.AppCompatTheme_editTextStyle /* 70 */:
                    case R.styleable.AppCompatTheme_listChoiceIndicatorMultipleAnimated /* 74 */:
                    case 'L':
                    case R.styleable.AppCompatTheme_listMenuViewStyle /* 77 */:
                    case R.styleable.AppCompatTheme_listPopupWindowStyle /* 78 */:
                    case R.styleable.AppCompatTheme_listPreferredItemPaddingEnd /* 82 */:
                        stringBuffer2.append(charAt);
                        break;
                    case R.styleable.AppCompatTheme_homeAsUpIndicator /* 71 */:
                        int i3 = i + 1;
                        if ((!isLastChar(length, i3) || !isNextChar(stringBuffer, i, 'H')) && ((isLastChar(length, i3) || !isNextChar(stringBuffer, i, 'H') || isVowel(stringBuffer, i + 2)) && (i <= 0 || (!regionMatch(stringBuffer, i, "GN") && !regionMatch(stringBuffer, i, "GNED"))))) {
                            boolean isPreviousChar = isPreviousChar(stringBuffer, i, 'G');
                            if (!isLastChar(length, i) && FRONTV.indexOf(stringBuffer.charAt(i3)) >= 0 && !isPreviousChar) {
                                stringBuffer2.append('J');
                                break;
                            } else {
                                stringBuffer2.append('K');
                                break;
                            }
                        }
                        break;
                    case R.styleable.AppCompatTheme_imageButtonStyle /* 72 */:
                        if (!isLastChar(length, i) && ((i <= 0 || VARSON.indexOf(stringBuffer.charAt(i - 1)) < 0) && isVowel(stringBuffer, i + 1))) {
                            stringBuffer2.append('H');
                            break;
                        }
                        break;
                    case 'K':
                        if (i > 0) {
                            if (!isPreviousChar(stringBuffer, i, 'C')) {
                                stringBuffer2.append(charAt);
                                break;
                            }
                        } else {
                            stringBuffer2.append(charAt);
                            break;
                        }
                        break;
                    case R.styleable.AppCompatTheme_listPreferredItemHeightLarge /* 80 */:
                        if (isNextChar(stringBuffer, i, 'H')) {
                            stringBuffer2.append('F');
                            break;
                        } else {
                            stringBuffer2.append(charAt);
                            break;
                        }
                    case R.styleable.AppCompatTheme_listPreferredItemHeightSmall /* 81 */:
                        stringBuffer2.append('K');
                        break;
                    case R.styleable.AppCompatTheme_listPreferredItemPaddingLeft /* 83 */:
                        if (regionMatch(stringBuffer, i, "SH") || regionMatch(stringBuffer, i, "SIO") || regionMatch(stringBuffer, i, "SIA")) {
                            stringBuffer2.append('X');
                            break;
                        } else {
                            stringBuffer2.append('S');
                            break;
                        }
                        break;
                    case R.styleable.AppCompatTheme_listPreferredItemPaddingRight /* 84 */:
                        if (regionMatch(stringBuffer, i, "TIA") || regionMatch(stringBuffer, i, "TIO")) {
                            stringBuffer2.append('X');
                            break;
                        } else if (!regionMatch(stringBuffer, i, "TCH")) {
                            if (regionMatch(stringBuffer, i, "TH")) {
                                stringBuffer2.append('0');
                                break;
                            } else {
                                stringBuffer2.append('T');
                                break;
                            }
                        }
                        break;
                    case R.styleable.AppCompatTheme_panelBackground /* 86 */:
                        stringBuffer2.append('F');
                        break;
                    case R.styleable.AppCompatTheme_panelMenuListTheme /* 87 */:
                    case R.styleable.AppCompatTheme_popupMenuStyle /* 89 */:
                        if (!isLastChar(length, i) && isVowel(stringBuffer, i + 1)) {
                            stringBuffer2.append(charAt);
                            break;
                        }
                        break;
                    case R.styleable.AppCompatTheme_panelMenuListWidth /* 88 */:
                        stringBuffer2.append('K');
                        stringBuffer2.append('S');
                        break;
                    case R.styleable.AppCompatTheme_popupWindowStyle /* 90 */:
                        stringBuffer2.append('S');
                        break;
                }
                i++;
            } else {
                i++;
            }
            if (stringBuffer2.length() > getMaxCodeLen()) {
                stringBuffer2.setLength(getMaxCodeLen());
            }
        }
        return stringBuffer2.toString();
    }

    private boolean isVowel(StringBuffer stringBuffer, int i) {
        return VOWELS.indexOf(stringBuffer.charAt(i)) >= 0;
    }

    private boolean isPreviousChar(StringBuffer stringBuffer, int i, char c) {
        return i > 0 && i < stringBuffer.length() && stringBuffer.charAt(i - 1) == c;
    }

    private boolean isNextChar(StringBuffer stringBuffer, int i, char c) {
        return i >= 0 && i < stringBuffer.length() - 1 && stringBuffer.charAt(i + 1) == c;
    }

    private boolean regionMatch(StringBuffer stringBuffer, int i, String str) {
        if (i < 0 || (str.length() + i) - 1 >= stringBuffer.length()) {
            return false;
        }
        return stringBuffer.substring(i, str.length() + i).equals(str);
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (!(obj instanceof String)) {
            throw new EncoderException("Parameter supplied to Metaphone encode is not of type java.lang.String");
        }
        return metaphone((String) obj);
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        return metaphone(str);
    }

    public boolean isMetaphoneEqual(String str, String str2) {
        return metaphone(str).equals(metaphone(str2));
    }

    public int getMaxCodeLen() {
        return this.maxCodeLen;
    }

    public void setMaxCodeLen(int i) {
        this.maxCodeLen = i;
    }
}

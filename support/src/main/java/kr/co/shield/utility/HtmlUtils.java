package kr.co.shield.utility;

import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlUtils {
	
	private static final Pattern PATTERN = Pattern.compile("(&#[0-9]{2,3};)+");
	private static final LinkedHashMap<String, String> CODE_MAP;
	
	static {
		CODE_MAP = new LinkedHashMap<String, String>();
		CODE_MAP.put("&#09;", " ");                         // 수평탭
		CODE_MAP.put("&#10;", " ");                         // 줄 삽입
		CODE_MAP.put("&#32;", " ");                         // 여백
		CODE_MAP.put("&#33;", "!");                         // 느낌표
		CODE_MAP.put("&#34;", "\"");                        // &quot;   따옴표
		CODE_MAP.put("&#35;", "#");                         // 숫자기호
		CODE_MAP.put("&#36;", "$");                         // 달러
		CODE_MAP.put("&#37;", "%");                         // 백분율 기호
		CODE_MAP.put("&#38;", "&");                         // &amp;    Ampersand
		CODE_MAP.put("&#39;", "'");                         // 작은 따옴표
		CODE_MAP.put("&#40;", "(");                         // 왼쪽 괄호
		CODE_MAP.put("&#41;", ")");                         // 오른쪽 괄호
		CODE_MAP.put("&#42;", "*");                         // 아스트릭
		CODE_MAP.put("&#43;", "+");                         // 더하기 기호
		CODE_MAP.put("&#44;", ",");                         // 쉼표
		CODE_MAP.put("&#45;", "-");                         // Hyphen
		CODE_MAP.put("&#46;", ".");                         // 마침표
		CODE_MAP.put("&#47;", "/");                         // Solidus (slash)
		CODE_MAP.put("&#48;", "0");                         // 0
		CODE_MAP.put("&#49;", "1");                         // 1
		CODE_MAP.put("&#50;", "2");                         // 2
		CODE_MAP.put("&#51;", "3");                         // 3
		CODE_MAP.put("&#52;", "4");                         // 4
		CODE_MAP.put("&#53;", "5");                         // 5
		CODE_MAP.put("&#54;", "6");                         // 6
		CODE_MAP.put("&#55;", "7");                         // 7
		CODE_MAP.put("&#56;", "8");                         // 8
		CODE_MAP.put("&#57;", "9");                         // 9
		CODE_MAP.put("&#58;", ":");                         // 콜론
		CODE_MAP.put("&#59;", ";");                         // 세미콜론
		CODE_MAP.put("&#60;", "<");                         // &lt;     보다 작은
		CODE_MAP.put("&#61;", "=");                         // 등호
		CODE_MAP.put("&#62;", ">");                         // &gt;     보다 큰
		CODE_MAP.put("&#63;", "?");                         // 물음표
		CODE_MAP.put("&#64;", "@");                         // Commercial at
		CODE_MAP.put("&#65;", "A");                         // A
		CODE_MAP.put("&#66;", "B");                         // B
		CODE_MAP.put("&#67;", "C");                         // C
		CODE_MAP.put("&#68;", "D");                         // D
		CODE_MAP.put("&#69;", "E");                         // E
		CODE_MAP.put("&#70;", "F");                         // F
		CODE_MAP.put("&#71;", "G");                         // G
		CODE_MAP.put("&#72;", "H");                         // H
		CODE_MAP.put("&#73;", "I");                         // I
		CODE_MAP.put("&#74;", "J");                         // J
		CODE_MAP.put("&#75;", "K");                         // K
		CODE_MAP.put("&#76;", "L");                         // L
		CODE_MAP.put("&#77;", "M");                         // M
		CODE_MAP.put("&#78;", "N");                         // N
		CODE_MAP.put("&#79;", "O");                         // O
		CODE_MAP.put("&#80;", "P");                         // P
		CODE_MAP.put("&#81;", "Q");                         // Q
		CODE_MAP.put("&#82;", "R");                         // R
		CODE_MAP.put("&#83;", "S");                         // S
		CODE_MAP.put("&#84;", "T");                         // T
		CODE_MAP.put("&#85;", "U");                         // U
		CODE_MAP.put("&#86;", "V");                         // V
		CODE_MAP.put("&#87;", "W");                         // W
		CODE_MAP.put("&#88;", "X");                         // X
		CODE_MAP.put("&#89;", "Y");                         // Y
		CODE_MAP.put("&#90;", "Z");                         // Z
		CODE_MAP.put("&#91;", "[");                         // 왼쪽 대괄호
		CODE_MAP.put("&#92;", "\\");                        // 역슬래쉬
		CODE_MAP.put("&#93;", "]");                         // 오른쪽 대괄호
		CODE_MAP.put("&#94;", "^");                         // 탈자부호
		CODE_MAP.put("&#95;", "_");                         // 수평선
		CODE_MAP.put("&#96;", "`");                         // Acute accent
		CODE_MAP.put("&#97;", "a");                         // a
		CODE_MAP.put("&#98;", "b");                         // b
		CODE_MAP.put("&#99;", "c");                         // c
		CODE_MAP.put("&#100;", "d");                        // d
		CODE_MAP.put("&#101;", "e");                        // e
		CODE_MAP.put("&#102;", "f");                        // f
		CODE_MAP.put("&#103;", "g");                        // g
		CODE_MAP.put("&#104;", "h");                        // h
		CODE_MAP.put("&#105;", "i");                        // i
		CODE_MAP.put("&#106;", "j");                        // j
		CODE_MAP.put("&#107;", "k");                        // k
		CODE_MAP.put("&#108;", "l");                        // l
		CODE_MAP.put("&#109;", "m");                        // m
		CODE_MAP.put("&#110;", "n");                        // n
		CODE_MAP.put("&#111;", "o");                        // o
		CODE_MAP.put("&#112;", "p");                        // p
		CODE_MAP.put("&#113;", "q");                        // q
		CODE_MAP.put("&#114;", "r");                        // r
		CODE_MAP.put("&#115;", "s");                        // s
		CODE_MAP.put("&#116;", "t");                        // t
		CODE_MAP.put("&#117;", "u");                        // u
		CODE_MAP.put("&#118;", "v");                        // v
		CODE_MAP.put("&#119;", "w");                        // w
		CODE_MAP.put("&#120;", "x");                        // x
		CODE_MAP.put("&#121;", "y");                        // y
		CODE_MAP.put("&#122;", "z");                        // z
		CODE_MAP.put("&#123;", "{");                        // 왼쪽 중괄호
		CODE_MAP.put("&#124;", "|");                        // 수직선
		CODE_MAP.put("&#125;", "}");                        // 오른쪽 중괄호
		CODE_MAP.put("&#126;", "~");                        // 꼬리표
		CODE_MAP.put("&#160;", " ");                        // &nbsp;   Non-breaking space
		CODE_MAP.put("&#161;", "¡");                        // &iexcl;  거꾸로된 느낌표
		CODE_MAP.put("&#162;", "￠");                        // &cent;   센트 기호
		CODE_MAP.put("&#163;", "￡");                        // &pound;  파운드
		CODE_MAP.put("&#164;", "¤");                        // &curren; 현재 환율
		CODE_MAP.put("&#165;", "￥");                        // &yen;    엔
		CODE_MAP.put("&#166;", "|");                        // &brvbar; 끊어진 수직선
		CODE_MAP.put("&#167;", "§");                        // &sect;   섹션 기호
		CODE_MAP.put("&#168;", "¨");                        // &uml;    움라우트
		CODE_MAP.put("&#169;", "ⓒ");                        // &copy;   저작권
		CODE_MAP.put("&#170;", "ª");                        // &ordf;   Feminine ordinal
		CODE_MAP.put("&#171;", "≪");                        // &laquo;  왼쪽 꺾인 괄호
		CODE_MAP.put("&#172;", "￢");                        // &not;    부정
		CODE_MAP.put("&#173;", "­");                        // &shy;    Soft hyphen
		CODE_MAP.put("&#174;", "?");                        // &reg;    등록상표
		CODE_MAP.put("&#175;", "&hibar;");                  // &macr;   Macron accent
		CODE_MAP.put("&#176;", "°");                        // &deg;    Degree sign
		CODE_MAP.put("&#177;", "±");                        // &plusmn; Plus or minus
		CODE_MAP.put("&#178;", "²");                        // &sup2;   Superscript two
		CODE_MAP.put("&#179;", "³");                        // &sup3;   Superscript three
		CODE_MAP.put("&#180;", "´");                        // &acute;  Acute accent
		CODE_MAP.put("&#181;", "μ");                        // &micro;  Micro sign (Mu)
		CODE_MAP.put("&#182;", "¶");                        // &para;   문단기호
		CODE_MAP.put("&#183;", "·");                        // &middot; Middle dot
		CODE_MAP.put("&#184;", "¸");                        // &cedil;  Cedilla
		CODE_MAP.put("&#185;", "¹");                        // &sup1;   Superscript one
		CODE_MAP.put("&#186;", "º");                        // &ordm;   Masculine ordinal
		CODE_MAP.put("&#187;", "≫");                        // &raquo;  오른쪽 꺾인 괄호
		CODE_MAP.put("&#188;", "¼");                        // &frac14; 4분의 1
		CODE_MAP.put("&#189;", "½");                        // &frac12; 2분의 1
		CODE_MAP.put("&#190;", "¾");                        // &frac34; 4분의 3
		CODE_MAP.put("&#191;", "¿");                        // &iquest; 거꾸로된 물음표
		CODE_MAP.put("&#192;", "A");                        // &Agrave; Capital A, grave accent
		CODE_MAP.put("&#193;", "A");                        // &Aacute; Capital A, acute accent
		CODE_MAP.put("&#194;", "A");                        // &Acirc;  Capital A, circumflex accent
		CODE_MAP.put("&#195;", "A");                        // &Atilde; Capital A, tilde
		CODE_MAP.put("&#196;", "A");                        // &Auml;   Capital A, dieresis or umlaut mark
		CODE_MAP.put("&#197;", "A");                        // &Aring;  Capital A, ring (Angstrom)
		CODE_MAP.put("&#198;", "Æ");                        // &AElig;  Capital AE diphthong (ligature)
		CODE_MAP.put("&#199;", "C");                        // &Ccedil; Capital C, cedilla
		CODE_MAP.put("&#200;", "E");                        // &Egrave; Capital E, grave accent
		CODE_MAP.put("&#201;", "E");                        // &Eacute; Capital E, acute accent
		CODE_MAP.put("&#202;", "E");                        // &Ecirc;  Capital E, circumflex accent
		CODE_MAP.put("&#203;", "E");                        // &Euml;   Capital E, dieresis or umlaut mark
		CODE_MAP.put("&#204;", "I");                        // &Igrave; Capital I, grave accent
		CODE_MAP.put("&#205;", "I");                        // &Iacute; Capital I, acute accent
		CODE_MAP.put("&#206;", "I");                        // &Icirc;  Capital I, circumflex accent
		CODE_MAP.put("&#207;", "I");                        // &Iuml;   Capital I, dieresis or umlaut mark
		CODE_MAP.put("&#208;", "Ð");                        // &ETH;    Capital Eth, Icelandic
		CODE_MAP.put("&#209;", "N");                        // &Ntilde; Capital N, tilde
		CODE_MAP.put("&#210;", "O");                        // &Ograve; Capital O, grave accent
		CODE_MAP.put("&#211;", "O");                        // &Oacute; Capital O, acute accent
		CODE_MAP.put("&#212;", "O");                        // &Ocirc;  Capital O, circumflex accent
		CODE_MAP.put("&#213;", "O");                        // &Otilde; Capital O, tilde
		CODE_MAP.put("&#214;", "O");                        // &Ouml;   Capital O, dieresis or umlaut mark
		CODE_MAP.put("&#215;", "×");                        // &times;  Multiply sign
		CODE_MAP.put("&#216;", "Ø");                        // &Oslash; width="130"Capital O, slash
		CODE_MAP.put("&#217;", "U");                        // &Ugrave; Capital U, grave accent
		CODE_MAP.put("&#218;", "U");                        // &Uacute; Capital U, acute accent
		CODE_MAP.put("&#219;", "U");                        // &Ucirc;  Capital U, circumflex accent
		CODE_MAP.put("&#220;", "U");                        // &Uuml;   Capital U, dieresis or umlaut mark
		CODE_MAP.put("&#221;", "Y");                        // &Yacute; Capital Y, acute accent
		CODE_MAP.put("&#222;", "Þ");                        // &THORN;  Capital Thorn, Icelandic
		CODE_MAP.put("&#223;", "ß");                        // &szlig;  Small sharp s, German (sz ligature)
		CODE_MAP.put("&#224;", "a");                        // &agrave; Small a, grave accent
		CODE_MAP.put("&#225;", "a");                        // &aacute; Small a, acute accent
		CODE_MAP.put("&#226;", "a");                        // &acirc;  Small a, circumflex accent
		CODE_MAP.put("&#227;", "a");                        // &atilde; Small a, tilde
		CODE_MAP.put("&#228;", "a");                        // &auml;   Small a, dieresis or umlaut mark
		CODE_MAP.put("&#229;", "a");                        // &aring;  Small a, ring
		CODE_MAP.put("&#230;", "æ");                        // &aelig;  Small ae diphthong (ligature)
		CODE_MAP.put("&#231;", "c");                        // &ccedil; Small c, cedilla
		CODE_MAP.put("&#232;", "e");                        // &egrave; Small e, grave accent
		CODE_MAP.put("&#233;", "e");                        // &eacute; Small e, acute accent
		CODE_MAP.put("&#234;", "e");                        // &ecirc;  Small e, circumflex accent
		CODE_MAP.put("&#235;", "e");                        // &euml;   Small e, dieresis or umlaut mark
		CODE_MAP.put("&#236;", "i");                        // &igrave; Small i, grave accent
		CODE_MAP.put("&#237;", "i");                        // &iacute; Small i, acute accent
		CODE_MAP.put("&#238;", "i");                        // &icirc;  Small i, circumflex accent
		CODE_MAP.put("&#239;", "i");                        // &iuml;   Small i, dieresis or umlaut mark
		CODE_MAP.put("&#240;", "ð");                        // &eth;    Small eth, Icelandic
		CODE_MAP.put("&#241;", "n");                        // &ntilde; Small n, tilde
		CODE_MAP.put("&#242;", "o");                        // &ograve; Small o, grave accent
		CODE_MAP.put("&#243;", "o");                        // &oacute; Small o, acute accent
		CODE_MAP.put("&#244;", "o");                        // &ocirc;  Small o, circumflex accent
		CODE_MAP.put("&#245;", "o");                        // &otilde; Small o, tilde
		CODE_MAP.put("&#246;", "o");                        // &ouml;   Small o, dieresis or umlaut mark
		CODE_MAP.put("&#247;", "÷");                        // &divide; Division sign
		CODE_MAP.put("&#248;", "ø");                        // &oslash; Small o, slash
		CODE_MAP.put("&#249;", "u");                        // &ugrave; Small u, grave accent
		CODE_MAP.put("&#250;", "u");                        // &uacute; Small u, acute accent
		CODE_MAP.put("&#251;", "u");                        // &ucirc;  Small u, circumflex accent
		CODE_MAP.put("&#252;", "u");                        // &uuml;   Small u, dieresis or umlaut mark
		CODE_MAP.put("&#253;", "y");                        // &yacute; Small y, acute accent
		CODE_MAP.put("&#254;", "þ");                        // &thorn;  Small thorn, Icelandic
		CODE_MAP.put("&#255;", "y");                        // &yuml;   Small y, dieresis or umlaut mark
	}
	
	public static String replaceCode(String str) {
		// 패턴 검색
		Matcher m = PATTERN.matcher(str);
		int inx = 0;
		while (m.find()) {
			// 패턴만 추출 후 치환
			String code = m.group(inx++);
			str = str.replaceAll("("+code+")", CODE_MAP.get(code));
		}
		return str;
	}
	
//	public static void main(String[] args) {
//		String[] ops = { "Division sign;", "&#164;aaa&#216;", "가나다&#248;bbe" };
//		for (String op : ops) {
//			String o = op;
//			String n = replaceCode(op);
//			System.out.println(o + " -> " + n);
//		}
//	}
//	
}

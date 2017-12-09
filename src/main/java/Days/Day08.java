package Days;

import Days.tools.RegisterInstruction;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Day08 extends Day {

    /**
     * official input
     * <p>
     * solution part one: ___
     * <p>
     * solution part two: ___
     */
    private static final String myInput =
            "o dec -427 if wnh < -1\n" + "ugc dec -128 if baj <= 3\n" + "ugc inc 294 if xml <= -1\n" +
            "ugc inc -277 if wfu < -2\n" + "l inc 302 if sqf == 0\n" + "l inc -940 if wnh > -6\n" +
            "vke inc 687 if fy >= -3\n" + "b inc 976 if ugc > 118\n" + "rz dec 201 if jyi < 5\n" +
            "y dec -960 if l >= -647\n" + "baj dec 879 if xbp <= 3\n" + "vke dec 360 if b <= 981\n" +
            "az dec 237 if baj <= -875\n" + "wnh dec 818 if pp > -7\n" + "baj dec -434 if ugc >= 121\n" +
            "az inc 501 if k < 1\n" + "y inc 43 if sb < 4\n" + "e dec -195 if o < 3\n" + "y inc 729 if u == 0\n" +
            "l inc 993 if xbp <= 0\n" + "u inc -252 if o < 5\n" + "k inc 547 if k == 0\n" + "e inc -781 if c != 4\n" +
            "y inc -963 if k >= 545\n" + "k inc -906 if xml != -9\n" + "k dec 394 if rz <= -210\n" +
            "l dec 676 if baj < -442\n" + "rz inc -376 if sqf >= -7\n" + "l inc -388 if sz >= 6\n" +
            "jyi dec 464 if jyi < -1\n" + "sb dec -397 if rz == -577\n" + "jyi dec -391 if b != 975\n" +
            "rz dec 85 if xbp != 2\n" + "rz dec -971 if az != 255\n" + "e inc 622 if vke < 337\n" +
            "pp dec 506 if l < -318\n" + "k inc -471 if az < 262\n" + "wnh dec -346 if vke <= 331\n" +
            "sb dec 23 if o != 1\n" + "y dec -29 if k != -349\n" + "fy inc 83 if sb < 377\n" +
            "c dec -283 if tme < 3\n" + "az dec 852 if e == 34\n" + "fy inc 935 if b == 976\n" +
            "pp dec 553 if e <= 44\n" + "sz dec 847 if k < -366\n" + "wnh dec -717 if o != -1\n" +
            "xbp dec -607 if e == 26\n" + "jyi inc -362 if y > 788\n" + "wfu inc 306 if baj <= -440\n" +
            "sb inc -512 if pp == -1065\n" + "jyi dec -190 if sqf != -4\n" + "k dec 810 if sqf >= -6\n" +
            "u inc 76 if fy > 1011\n" + "sqf inc -844 if c <= 286\n" + "wnh inc -326 if k <= -1162\n" +
            "wnh dec -199 if baj == -447\n" + "k inc -828 if sqf < -839\n" + "wnh inc 288 if l > -321\n" +
            "o dec 769 if c != 280\n" + "pp dec -95 if rz > 299\n" + "vke dec -752 if b <= 982\n" +
            "rz inc 334 if pp == -964\n" + "sqf inc 987 if y >= 797\n" + "eia inc -938 if az > 271\n" +
            "tme dec 849 if b > 972\n" + "vke inc 322 if c <= 282\n" + "l inc -43 if baj >= -446\n" +
            "fy dec 760 if rz <= 641\n" + "sqf dec 947 if wnh != -80\n" + "e inc 267 if eia == -6\n" +
            "xbp dec -340 if b >= 975\n" + "xbp dec 887 if wfu != 315\n" + "az inc 911 if o < -766\n" +
            "sb inc 494 if wnh < -87\n" + "sqf dec -25 if sz <= 8\n" + "fy dec -36 if xml == 0\n" +
            "ugc dec 429 if rz >= 652\n" + "sz dec 139 if ugc <= 130\n" + "eia inc -762 if sz != -141\n" +
            "c inc 868 if vke == 1079\n" + "l dec 36 if pp > -974\n" + "jyi dec -645 if wnh != -81\n" +
            "tme inc -361 if tme > -840\n" + "sqf inc 761 if eia != -762\n" + "o inc 361 if xbp != -548\n" +
            "pp dec -999 if pp > -969\n" + "sz inc -383 if k <= -1995\n" + "y dec -940 if ugc != 132\n" +
            "sqf dec -957 if k < -1989\n" + "tme dec 528 if e >= 38\n" + "baj inc -803 if rz == 643\n" +
            "y inc 799 if sz > -530\n" + "fy dec 120 if vke != 1086\n" + "wnh inc 141 if pp <= 36\n" +
            "c dec 481 if wfu == 306\n" + "tme inc 536 if eia < -758\n" + "sz inc 954 if u <= -174\n" +
            "o dec 473 if y <= 2528\n" + "l dec 976 if wfu >= 297\n" + "tme inc -26 if baj != -1252\n" +
            "k dec 786 if xml > -7\n" + "az dec 817 if sqf == 178\n" + "c dec 980 if k == -2776\n" +
            "baj dec -954 if tme == -348\n" + "rz inc -178 if vke <= 1088\n" + "jyi inc 426 if fy >= 930\n" +
            "xbp inc -708 if wnh >= 63\n" + "c inc 364 if az > 353\n" + "l dec -393 if xml == 0\n" +
            "wfu dec -619 if l != -983\n" + "y inc -454 if xbp == -547\n" + "wnh inc 909 if jyi >= 642\n" +
            "az inc 251 if k > -2777\n" + "c inc 985 if rz >= 470\n" + "e inc -810 if wnh <= 978\n" +
            "e inc 785 if fy == 934\n" + "wnh dec -872 if vke >= 1083\n" + "baj dec -827 if rz > 457\n" +
            "wfu dec -186 if sqf > 170\n" + "sqf inc 522 if wnh > 970\n" + "sb inc 307 if wfu <= 489\n" +
            "ugc dec -765 if sz == 432\n" + "wfu inc 429 if e > 7\n" + "fy inc 730 if jyi <= 653\n" +
            "sb dec -265 if sb >= 376\n" + "b dec -276 if c == 1033\n" + "u inc -99 if k > -2788\n" +
            "e inc 114 if l >= -986\n" + "vke dec -845 if wnh >= 963\n" + "c inc -263 if xbp > -549\n" +
            "sz inc 905 if sz > 425\n" + "baj dec 298 if o >= -412\n" + "l dec 118 if baj == -719\n" +
            "rz inc -472 if pp >= 31\n" + "sb dec 489 if fy <= 1670\n" + "xbp dec 876 if sqf == 178\n" +
            "y dec 504 if o != -407\n" + "u inc 410 if xbp >= -1427\n" + "xml dec 95 if xml != -2\n" +
            "wfu dec 440 if xml <= -101\n" + "sqf dec -270 if pp <= 39\n" + "k inc -812 if pp >= 34\n" +
            "jyi dec -498 if pp > 27\n" + "jyi dec 848 if vke != 1924\n" + "xbp inc 675 if sqf > 440\n" +
            "jyi dec -697 if b <= 981\n" + "jyi dec 172 if baj > -725\n" + "fy inc 349 if c >= 767\n" +
            "wnh inc -683 if c >= 771\n" + "e inc -667 if u <= 144\n" + "jyi dec -991 if rz != -7\n" +
            "sb inc 547 if k < -3586\n" + "l inc -645 if jyi != 1669\n" + "sqf dec 912 if xml > -99\n" +
            "u inc 782 if az >= 354\n" + "az dec 752 if xbp > -755\n" + "y dec 296 if k >= -3603\n" +
            "c dec -816 if fy >= 2007\n" + "sqf inc 776 if pp < 43\n" + "wfu inc 502 if l != -1742\n" +
            "sb dec 228 if e != -542\n" + "fy inc 171 if k == -3595\n" + "wnh dec 998 if jyi < 1663\n" +
            "k dec -762 if xbp == -748\n" + "tme dec -660 if az == -394\n" + "eia inc 969 if vke == 1924\n" +
            "l inc -324 if sqf != 309\n" + "az inc -982 if sz >= 1336\n" + "rz dec 651 if tme == 321\n" +
            "xbp dec -196 if vke == 1924\n" + "eia inc 538 if b > 973\n" + "eia inc -326 if k >= -2842\n" +
            "baj dec -47 if eia <= 422\n" + "jyi inc -851 if eia == 419\n" + "ugc dec -846 if xbp >= -553\n" +
            "e inc -473 if wfu < 1424\n" + "sqf inc -401 if k < -2832\n" + "c inc 975 if c > 1591\n" +
            "o inc -235 if xbp == -552\n" + "xml dec -34 if k < -2827\n" + "xbp inc 333 if e >= -1016\n" +
            "baj dec -74 if sz > 1327\n" + "xml dec -288 if vke >= 1921\n" + "sqf inc -180 if pp <= 42\n" +
            "wfu dec 820 if b != 971\n" + "e inc -113 if vke <= 1923\n" + "jyi inc 466 if rz > -661\n" +
            "eia inc -410 if pp != 44\n" + "az dec -404 if l > -2078\n" + "wfu inc -537 if az < -979\n" +
            "xbp inc -667 if pp != 37\n" + "sz inc -774 if b == 979\n" + "sz dec 35 if b >= 979\n" +
            "b inc -641 if e < -1020\n" + "eia dec 914 if c <= 1588\n" + "pp inc -250 if o > -647\n" +
            "b dec 46 if k < -2830\n" + "u inc 275 if c < 1589\n" + "rz dec -946 if az < -971\n" +
            "sqf inc -197 if sz == 1337\n" + "sqf dec -853 if tme >= 321\n" + "b dec -719 if b >= 923\n" +
            "baj dec 614 if e == -1015\n" + "o inc -224 if u < 1195\n" + "sqf dec 130 if vke <= 1925\n" +
            "eia inc 388 if xml >= 224\n" + "xbp dec 561 if pp > -218\n" + "o dec -959 if k >= -2841\n" +
            "tme inc -89 if az >= -972\n" + "xml dec 745 if b >= 1652\n" + "baj dec 649 if xml <= 235\n" +
            "wfu inc -762 if o <= 101\n" + "l inc 424 if jyi >= 1277\n" + "rz dec 685 if o == 101\n" +
            "u dec -49 if baj >= -1868\n" + "u dec -495 if eia >= -517\n" + "az inc -450 if y > 1273\n" +
            "sz dec -860 if y == 1283\n" + "wnh inc -896 if xml >= 226\n" + "eia dec -319 if tme >= 229\n" +
            "vke inc -535 if o == 92\n" + "vke dec 10 if fy > 2190\n" + "b dec -683 if l == -1646\n" +
            "tme dec -522 if jyi > 1274\n" + "tme inc -211 if wnh < -604\n" + "u dec -383 if rz <= 285\n" +
            "baj inc 928 if u >= 1732\n" + "eia inc -286 if y <= 1282\n" + "pp dec -422 if ugc <= 1747\n" +
            "e dec -123 if o != 96\n" + "u dec -163 if wfu == -159\n" + "y dec 802 if rz <= 289\n" +
            "o dec -992 if eia >= -199\n" + "sqf dec 275 if e < -887\n" + "az inc 801 if e < -889\n" +
            "pp inc 893 if c < 1595\n" + "sz inc 913 if o < 1094\n" + "wfu inc 870 if k <= -2833\n" +
            "tme inc -203 if wnh < -609\n" + "eia dec 431 if xml < 228\n" + "sqf dec -722 if sz == 3110\n" +
            "xml inc -527 if fy > 2175\n" + "sqf dec -314 if fy < 2176\n" + "baj inc -425 if l < -1636\n" +
            "rz dec -774 if k >= -2838\n" + "jyi inc -797 if pp != 1097\n" + "u inc 856 if o < 1091\n" +
            "ugc dec 29 if o > 1089\n" + "wnh dec 629 if rz <= 1070\n" + "rz dec 919 if fy != 2184\n" +
            "wfu dec -789 if fy >= 2178\n" + "o inc 229 if wfu < 1491\n" + "wnh inc -873 if sb != 432\n" +
            "wfu inc -29 if rz != 1062\n" + "pp dec 542 if ugc == 1739\n" + "tme dec -321 if l <= -1638\n" +
            "baj dec 515 if b < 2340\n" + "k dec 976 if sqf >= 701\n" + "e dec -940 if eia >= -631\n" +
            "b inc 173 if l <= -1644\n" + "e inc 649 if sb < 439\n" + "ugc inc 598 if c > 1579\n" +
            "baj dec 920 if u == 2755\n" + "sz inc 165 if eia < -622\n" + "c inc -461 if fy != 2181\n" +
            "sqf dec -574 if pp == 558\n" + "jyi inc -511 if o <= 1089\n" + "k dec -876 if pp == 558\n" +
            "l dec -830 if wnh < -1234\n" + "az inc -524 if pp < 550\n" + "y inc 141 if vke < 1383\n" +
            "tme inc 365 if rz <= 1067\n" + "u inc 33 if e >= 696\n" + "sqf inc -241 if sz == 3275\n" +
            "k dec 918 if baj == -2793\n" + "jyi inc 82 if y > 471\n" + "sb dec 730 if k >= -3857\n" +
            "u dec -690 if wnh <= -1237\n" + "jyi dec 962 if e >= 695\n" + "xml dec -513 if wnh <= -1238\n" +
            "sqf inc -77 if sz >= 3285\n" + "wfu inc 697 if az > -624\n" + "l dec 200 if eia < -621\n" +
            "l inc 258 if k < -3846\n" + "wnh dec -578 if b <= 2513\n" + "l inc -871 if wnh < -659\n" +
            "pp dec 916 if b < 2496\n" + "eia inc -445 if fy <= 2189\n" + "b dec -759 if o >= 1077\n" +
            "ugc inc -582 if xml != 219\n" + "vke dec 915 if sz < 3280\n" + "e dec 752 if sz != 3271\n" +
            "k inc 447 if pp > 550\n" + "wnh inc -272 if jyi > -910\n" + "b inc 762 if xml >= 209\n" +
            "vke inc 33 if eia < -1070\n" + "wnh dec -943 if vke >= 501\n" + "y dec -627 if wnh != 4\n" +
            "k dec -240 if eia >= -1080\n" + "tme inc -731 if eia <= -1069\n" + "y inc 138 if pp < 567\n" +
            "wfu dec -839 if u < 3480\n" + "sz dec -268 if az >= -624\n" + "tme inc 413 if l > -1629\n" +
            "vke inc 699 if l == -1626\n" + "pp dec 962 if fy != 2179\n" + "pp inc -972 if eia != -1068\n" +
            "e dec -223 if xbp < -1445\n" + "pp inc -559 if xbp > -1440\n" + "pp inc -869 if sb <= -299\n" +
            "wfu dec 229 if sz == 3543\n" + "az dec -885 if fy != 2189\n" + "tme inc -542 if wfu >= 2806\n" +
            "sqf dec -797 if e >= 172\n" + "l inc -159 if c >= 1119\n" + "baj dec 602 if e > 158\n" +
            "sb dec -546 if sb < -295\n" + "ugc inc -531 if k != -3171\n" + "xbp inc -800 if sqf > 1033\n" +
            "eia dec 281 if tme >= -255\n" + "b inc -997 if tme != -247\n" + "k inc 140 if xml >= 216\n" +
            "pp inc -83 if pp > -1377\n" + "sb inc -697 if l <= -1781\n" + "baj inc 101 if wnh < 19\n" +
            "b inc -330 if wnh < 17\n" + "baj dec -602 if ugc > 1219\n" + "fy dec 642 if tme == -247\n" +
            "e inc 212 if c >= 1120\n" + "sqf dec 693 if c > 1122\n" + "tme dec 277 if az <= 265\n" +
            "k dec 430 if ugc >= 1222\n" + "rz inc 182 if wfu >= 2806\n" + "sb inc 158 if wfu == 2807\n" +
            "wfu inc -223 if wfu == 2807\n" + "pp dec -734 if ugc != 1224\n" + "rz dec -809 if c != 1124\n" +
            "vke dec -963 if y < 1247\n" + "sqf dec -654 if l != -1791\n" + "az dec -939 if o < 1090\n" +
            "eia inc 753 if vke == 1470\n" + "fy dec 494 if u > 3473\n" + "jyi inc -739 if ugc > 1217\n" +
            "jyi inc 216 if e != 380\n" + "l inc -95 if ugc > 1222\n" + "pp dec 400 if baj > -2695\n" +
            "o dec -915 if k < -3603\n" + "c dec 810 if c <= 1128\n" + "fy dec 33 if k >= -3598\n" +
            "c inc -193 if sz <= 3540\n" + "ugc inc -415 if l > -1885\n" + "c inc 12 if baj != -2692\n" +
            "eia dec 376 if c != 309\n" + "jyi inc 168 if xbp != -2255\n" + "u dec 814 if sz != 3553\n" +
            "wfu dec 247 if xbp != -2247\n" + "xml dec -716 if eia <= -970\n" + "sqf dec -985 if baj <= -2689\n" +
            "sz inc 280 if pp != -1867\n" + "tme dec 277 if jyi <= -1475\n" + "pp dec 122 if l == -1883\n" +
            "tme dec -329 if sz != 3818\n" + "eia dec 980 if sb == -291\n" + "jyi inc 373 if b > 3696\n" +
            "y inc -203 if baj < -2688\n" + "ugc inc 263 if u == 2664\n" + "eia inc -278 if xbp >= -2250\n" +
            "ugc dec 654 if xbp <= -2246\n" + "fy inc 814 if rz == 2053\n" + "wnh inc 709 if y != 1034\n" +
            "e dec 939 if tme > -476\n" + "wfu inc -792 if az > 1193\n" + "u inc -506 if baj <= -2689\n" +
            "b inc 350 if vke == 1480\n" + "o inc 938 if o > 1074\n" + "jyi inc -219 if rz == 2053\n" +
            "wfu dec 349 if u >= 2162\n" + "u dec -97 if o > 2025\n" + "pp inc -211 if vke != 1471\n" +
            "wfu dec -194 if b < 3699\n" + "l dec 96 if sqf <= 1980\n" + "vke dec 179 if az >= 1198\n" +
            "vke dec -317 if wnh != 719\n" + "tme inc 606 if baj < -2689\n" + "k dec 148 if fy > 1829\n" +
            "jyi dec 294 if y >= 1041\n" + "wfu inc 963 if xbp > -2245\n" + "sb dec -932 if o == 2022\n" +
            "wnh inc -640 if c <= 316\n" + "rz inc 90 if o != 2021\n" + "tme inc 466 if rz != 2134\n" +
            "l dec -771 if k < -3586\n" + "vke dec 91 if e <= -551\n" + "fy dec -312 if b < 3705\n" +
            "vke dec -529 if wnh >= 71\n" + "b dec -595 if xml < 937\n" + "tme dec 540 if b != 4293\n" +
            "o dec 502 if baj <= -2702\n" + "tme inc -270 if jyi > -1991\n" + "b dec -298 if u >= 2157\n" +
            "c dec -599 if sz <= 3813\n" + "y dec -909 if b > 4588\n" + "y inc 477 if pp != -2201\n" +
            "xbp inc 201 if u < 2163\n" + "jyi inc 101 if sb >= 636\n" + "l dec 75 if b == 4589\n" +
            "e inc -15 if e <= -558\n" + "fy inc -471 if sb != 638\n" + "jyi inc 715 if u < 2167\n" +
            "pp dec 364 if az == 1203\n" + "az dec -740 if sqf >= 1988\n" + "tme inc 772 if wnh < 75\n" +
            "k dec 634 if u > 2156\n" + "eia dec 141 if u <= 2162\n" + "baj dec 776 if l < -1184\n" +
            "wnh dec -920 if fy <= 1677\n" + "xbp dec 169 if c <= 320\n" + "sqf inc -193 if vke < 1736\n" +
            "fy dec 96 if vke > 1724\n" + "u inc -282 if az < 1206\n" + "xml inc -395 if wnh != 1000\n" +
            "az inc -492 if k <= -4233\n" + "sz inc -210 if u < 1883\n" + "c inc -584 if eia == -2380\n" +
            "pp inc -772 if wnh >= 994\n" + "ugc inc -946 if xml >= 528\n" + "l dec -848 if rz < 2147\n" +
            "o dec -570 if sqf > 1780\n" + "ugc inc -849 if e < -564\n" + "sb dec -327 if pp > -3332\n" +
            "sqf dec -937 if u != 1869\n" + "xbp inc 765 if o >= 2592\n" + "ugc inc -2 if fy > 1574\n" +
            "xml inc -976 if y < 2432\n" + "o inc 762 if b > 4587\n" + "xml inc 384 if tme == -210\n" +
            "u inc -612 if wnh < 1005\n" + "u inc -229 if e != -582\n" + "eia dec 814 if wfu <= 1989\n" +
            "fy inc -41 if sb > 964\n" + "fy dec -487 if wnh != 1004\n" + "xml dec -44 if jyi < -1164\n" +
            "k dec 107 if sqf == 2727\n" + "sz inc -819 if rz < 2141\n" + "k inc 862 if wnh < 1009\n" +
            "vke inc -935 if b == 4592\n" + "k dec -547 if y != 2429\n" + "k dec -804 if l >= -331\n" +
            "o dec -869 if jyi >= -1178\n" + "fy inc -527 if wfu != 1986\n" + "vke inc -900 if jyi <= -1175\n" +
            "ugc inc 878 if pp < -3322\n" + "sz inc 96 if eia > -3192\n" + "tme inc -888 if l != -346\n" +
            "rz dec -879 if e == -574\n" + "y inc -89 if wfu <= 1983\n" + "u dec 106 if xml <= -21\n" +
            "az dec 724 if y <= 2423\n" + "sb inc -951 if wnh == 999\n" + "wnh inc -583 if xbp == -1450\n" +
            "sz dec -906 if c >= 311\n" + "az inc -192 if b <= 4583\n" + "l dec 307 if vke <= 1728\n" +
            "xbp dec 553 if xbp >= -1455\n" + "u inc 581 if tme > -1100\n" + "e inc 993 if xml >= -22\n" +
            "baj dec 484 if y != 2422\n" + "u dec 797 if xbp <= -2002\n" + "xml dec -448 if sqf > 2729\n" +
            "l dec -97 if wnh <= 413\n" + "c dec -211 if baj <= -3959\n" + "k dec 925 if xbp > -2008\n" +
            "wnh inc 198 if c == 316\n" + "l inc 22 if l <= -331\n" + "jyi inc -293 if xbp <= -2006\n" +
            "e dec 271 if y <= 2432\n" + "pp dec 309 if pp > -3327\n" + "c dec 645 if jyi <= -1181\n" +
            "l inc 706 if y <= 2428\n" + "xbp inc 477 if c >= 307\n" + "l inc -998 if u != 811\n" +
            "xbp inc 879 if az != 1193\n" + "k dec 954 if wfu != 1985\n" + "sb inc -627 if jyi == -1173\n" +
            "vke inc 766 if wnh != 614\n" + "pp inc -177 if wnh != 616\n" + "y inc -426 if wfu == 1986\n" +
            "wnh inc -932 if wfu >= 1979\n" + "sqf inc 328 if u != 821\n" + "l dec -995 if u < 827\n" +
            "xml inc 856 if sb < -606\n" + "tme dec 985 if b >= 4586\n" + "y dec 992 if wnh > -320\n" +
            "baj dec -833 if y == 1011\n" + "fy dec -733 if vke <= 1735\n" + "xml inc 471 if ugc <= -491\n" +
            "c dec -970 if tme < -2082\n" + "eia inc -404 if sqf != 3051\n" + "sqf inc 646 if rz < 3025\n" +
            "jyi dec 997 if vke >= 1729\n" + "c inc 114 if pp <= -3502\n" + "b inc 385 if l != -322\n" +
            "ugc inc -76 if rz < 3016\n" + "sqf dec -180 if wfu == 1986\n" + "jyi inc 876 if jyi == -2170\n" +
            "jyi inc -663 if c == 1400\n" + "k dec -530 if sb >= -612\n" + "jyi inc 790 if rz < 3032\n" +
            "vke dec -964 if wnh >= -319\n" + "k inc 165 if ugc > -505\n" + "xml dec -928 if vke > 2684\n" +
            "pp inc 739 if e < 155\n" + "sz inc 711 if baj < -3110\n" + "o inc -420 if y < 1020\n" +
            "xbp inc 362 if jyi <= -1162\n" + "wnh inc -228 if az > 1201\n" + "jyi inc 931 if xbp < -275\n" +
            "rz inc 650 if wfu > 1983\n" + "rz inc 136 if k > -4667\n" + "c dec -923 if xml != 2236\n" +
            "az dec -127 if u == 819\n" + "fy dec 717 if baj <= -3115\n" + "eia inc 14 if o <= 3807\n" +
            "tme inc 928 if sqf >= 3879\n" + "vke inc -148 if e <= 155\n" + "tme inc 959 if az <= 1337\n" +
            "c dec 306 if e <= 139\n" + "vke inc -622 if b == 4974\n" + "c inc -818 if sb >= -611\n" +
            "az inc -107 if l >= -328\n" + "l dec 42 if u <= 826\n" + "fy inc -175 if ugc == -508\n" +
            "e inc 208 if o <= 3806\n" + "fy inc 239 if c != 1515\n" + "sz dec -678 if wnh != -542\n" +
            "sz dec 660 if e < 348\n" + "az dec 636 if wfu > 1982\n" + "tme inc -537 if k > -4658\n" +
            "sb dec 977 if eia <= -3580\n" + "u inc -171 if b < 4982\n" + "wnh inc 141 if baj == -3119\n" +
            "rz inc -648 if l == -362\n" + "eia dec 910 if eia != -3579\n" + "sz dec -202 if l != -355\n" +
            "fy dec -235 if sz <= 6214\n" + "vke inc 635 if eia == -4491\n" + "eia inc -472 if b < 4977\n" +
            "k dec -936 if tme < -729\n" + "u dec -793 if eia <= -4958\n" + "jyi inc -273 if jyi == -236\n" +
            "xml dec 101 if u == 1441\n" + "baj inc 553 if sz > 6205\n" + "c dec -315 if wfu <= 1995\n" +
            "e dec 504 if l < -356\n" + "u dec -563 if eia > -4968\n" + "wnh inc -81 if pp != -2768\n" +
            "rz dec -784 if xml == 2140\n" + "xbp dec 113 if l != -366\n" + "b dec -545 if vke > 2554\n" +
            "c dec -978 if e <= -151\n" + "baj dec -782 if eia == -4963\n" + "wnh dec 524 if pp < -2765\n" +
            "sz dec 272 if sb >= -1587\n" + "baj inc -501 if jyi > -519\n" + "xml dec -246 if y < 1013\n" +
            "az inc -607 if xml < 2377\n" + "az dec -25 if pp >= -2769\n" + "pp dec -488 if eia < -4962\n" +
            "b inc -551 if xml > 2382\n" + "sz inc 318 if az == 612\n" + "xml dec -645 if pp == -2278\n" +
            "u dec 681 if e < -140\n" + "b inc -690 if sb >= -1588\n" + "baj dec 927 if xml < 3034\n" +
            "e dec 645 if wnh >= -1015\n" + "sqf dec 621 if xbp <= -394\n" + "rz inc 963 if fy <= 2513\n" +
            "tme dec -163 if sz == 6252\n" + "vke inc -132 if baj > -3220\n" + "tme inc -151 if sqf <= 3265\n" +
            "az dec 47 if fy >= 2505\n" + "u inc -185 if vke > 2421\n" + "jyi inc 785 if sb != -1582\n" +
            "k dec -427 if e > -795\n" + "sz dec 652 if xbp != -395\n" + "eia inc -102 if eia >= -4967\n" +
            "b inc -860 if wfu < 1990\n" + "rz dec -501 if b > 3416\n" + "y dec -772 if pp == -2278\n" +
            "sz dec -982 if y >= 1777\n" + "rz inc 874 if fy != 2510\n" + "fy inc 965 if rz < 5410\n" +
            "sb inc 303 if c < 1830\n" + "pp inc 658 if wnh == -1010\n" + "fy inc 206 if xml > 3029\n" +
            "fy dec 60 if az > 558\n" + "xbp inc -260 if jyi != 276\n" + "xbp inc 398 if e >= -799\n" +
            "sb dec -532 if xml < 3036\n" + "wfu inc -63 if az != 565\n" + "ugc inc -898 if xbp <= 0\n" +
            "rz dec 875 if e < -789\n" + "l inc -517 if az < 558\n" + "wnh dec 936 if u == 1138\n" +
            "k inc 665 if pp >= -1623\n" + "xbp inc 200 if rz == 4533\n" + "k inc 521 if b < 3428\n" +
            "baj dec -634 if baj >= -3215\n" + "l dec 265 if rz > 4523\n" + "sb dec -725 if l >= -624\n" +
            "eia inc 959 if wnh < -1944\n" + "rz dec 721 if b == 3418\n" + "sqf inc -659 if sb <= -746\n" +
            "pp dec -30 if sb == -752\n" + "sqf dec 938 if b <= 3424\n" + "k inc 166 if k < -2108\n" +
            "u dec 392 if o >= 3799\n" + "l inc -784 if tme == -721\n" + "sb dec 217 if pp >= -1596\n" +
            "wnh dec -926 if b == 3418\n" + "u inc -7 if rz < 3821\n" + "sb dec -197 if baj >= -2582\n" +
            "u inc -449 if vke > 2419\n" + "c dec 688 if c <= 1827\n" + "fy dec 53 if sz < 6578\n" +
            "c dec 687 if jyi < 284\n" + "pp dec -391 if tme == -721\n" + "pp dec 695 if ugc <= -1392\n" +
            "xbp dec 132 if e > -803\n" + "e dec 215 if eia > -4111\n" + "sb dec 602 if eia > -4112\n" +
            "xbp inc -885 if baj == -2578\n" + "vke dec -709 if sqf >= 1655\n" + "az dec -378 if xbp > -819\n" +
            "vke dec -263 if sb != -1368\n" + "baj dec -783 if l >= -1413\n" + "k inc 792 if c != 442\n" +
            "c inc -31 if sb < -1368\n" + "sb dec 904 if rz < 3821\n" + "fy inc 167 if eia == -4106\n" +
            "xml inc -764 if e > -999\n" + "wnh dec -530 if baj <= -1794\n" + "jyi dec -748 if e >= -998\n" +
            "u inc -653 if e >= -1014\n" + "tme inc -791 if l <= -1403\n" + "fy dec -800 if e == -1008\n" +
            "az dec 783 if k < -1313\n" + "e inc -553 if pp >= -1900\n" + "wfu dec -472 if baj < -1802\n" +
            "xbp dec -53 if b >= 3427\n" + "fy dec 174 if xbp < -816\n" + "o dec 581 if vke < 3406\n" +
            "k inc -458 if y <= 1785\n" + "az inc 59 if az == 160\n" + "tme inc 291 if wfu > 1978\n" +
            "pp dec -933 if wfu >= 1989\n" + "jyi dec -982 if l >= -1415\n" + "pp inc 403 if jyi == 1258\n" +
            "l inc -149 if pp >= -1491\n" + "fy dec -663 if sb < -2275\n" + "vke inc -866 if vke >= 3401\n" +
            "sqf dec -397 if l < -1553\n" + "xbp inc 1000 if wfu > 1981\n" + "wnh inc -188 if wfu >= 1979\n" +
            "l dec -260 if l > -1569\n" + "baj inc 109 if xml <= 3033\n" + "wfu dec -98 if rz < 3820\n" +
            "az inc -676 if c < 417\n" + "e dec -459 if wfu != 2083\n" + "sb inc -556 if sz >= 6586\n" +
            "l dec -104 if pp != -1490\n" + "jyi dec 835 if e < -1096\n" + "u inc 63 if wfu < 2094\n" +
            "k dec 531 if ugc > -1405\n" + "wfu dec 438 if xbp < 184\n" + "wnh dec 304 if sz < 6589\n" +
            "xml inc -278 if ugc <= -1391\n" + "pp inc -25 if y == 1783\n" + "k dec 179 if xml == 2753\n" +
            "wfu dec 711 if u > -303\n" + "eia dec 575 if wfu >= 931\n" + "sb inc -1 if ugc <= -1398\n" +
            "pp dec -948 if xml >= 2751\n" + "xbp dec -441 if pp >= -558\n" + "baj inc -558 if fy == 5077\n" +
            "c dec -901 if sqf < 2063\n" + "xml dec 572 if jyi >= 420\n" + "c dec -286 if sqf >= 2051\n" +
            "az inc 1 if tme >= -1221\n" + "c dec 551 if eia > -4682\n" + "sz dec 261 if xml == 2181\n" +
            "b dec 354 if l >= -1192\n" + "jyi inc 34 if xbp != 188\n" + "wnh inc -591 if wfu == 935\n" +
            "eia inc 639 if rz > 3807\n" + "sqf inc 211 if sz != 6320\n" + "fy inc 310 if baj < -2241\n" +
            "fy inc -680 if az < -451\n" + "b inc -352 if pp == -576\n" + "k dec -704 if sqf != 2280\n" +
            "ugc inc -664 if c == 1050\n" + "eia inc -501 if e < -1103\n" + "u dec 943 if b >= 3414\n" +
            "baj inc -20 if sb >= -2284\n" + "eia dec 571 if jyi > 461\n" + "u dec 642 if o > 3212\n" +
            "b inc -212 if rz >= 3808\n" + "k dec -305 if wfu < 926\n" + "eia dec -47 if k >= -1784\n" +
            "u inc -15 if sz > 6316\n" + "ugc inc -61 if xml <= 2184\n" + "sz dec 663 if fy > 4700\n" +
            "vke dec -340 if k == -1780\n" + "eia dec 103 if l >= -1188\n" + "vke inc -941 if wfu != 928\n" +
            "baj inc 323 if rz > 3813\n" + "fy dec 41 if wnh != -1573\n" + "jyi inc 20 if pp >= -573\n" +
            "o dec -656 if e != -1099\n" + "sb dec 473 if tme >= -1225\n" + "b dec 622 if vke != 2797\n" +
            "c inc 484 if tme < -1221\n" + "rz inc 363 if y > 1780\n" + "b inc -74 if e != -1105\n" +
            "sz dec -38 if k < -1784\n" + "b dec -518 if xbp <= 192\n" + "xbp inc -795 if sqf >= 2265\n" +
            "u inc -484 if baj >= -2268\n" + "fy dec 302 if wfu == 935\n" + "k dec 643 if wnh == -1566\n" +
            "wnh inc 16 if xbp < -611\n" + "eia dec 289 if pp >= -575\n" + "b inc 673 if rz == 4175\n" +
            "wnh inc 305 if wfu <= 935\n" + "b inc 18 if wfu == 935\n" + "az inc 810 if pp == -568\n" +
            "sb dec -609 if pp >= -559\n" + "sz dec 311 if ugc >= -2122\n" + "wfu dec -836 if wnh == -1252\n" +
            "wfu dec -78 if baj <= -2270\n" + "baj dec -186 if wfu < 1779\n" + "c dec -129 if tme > -1220\n" +
            "fy dec 662 if tme != -1214\n" + "jyi inc 624 if u != -2394\n" + "sb inc -906 if pp != -573\n" +
            "rz dec -263 if wfu >= 1780\n" + "k inc -364 if xml > 2179\n" + "rz dec 214 if ugc < -2117\n" +
            "o dec -539 if xbp < -606\n" + "wnh inc -708 if l <= -1188\n" + "sqf dec -901 if y != 1785\n" +
            "ugc dec 0 if c != 1048\n" + "wnh dec 712 if b < 4338\n" + "wnh dec -554 if baj < -2086\n" +
            "sb dec 777 if baj == -2078\n" + "l dec 713 if c > 1046\n" + "o inc 44 if eia == -4284\n" +
            "rz inc 77 if o != 4456\n" + "xml inc 862 if az > 346\n" + "wfu dec 242 if k > -2151\n" +
            "b dec 998 if k >= -2152\n" + "sz dec 202 if o != 4460\n" + "tme inc 941 if wfu < 1537\n" +
            "pp inc -536 if c == 1050\n" + "wfu inc 557 if y != 1781\n" + "e inc -982 if y != 1783\n" +
            "u dec -49 if y != 1790\n" + "az inc 602 if jyi <= 1102\n" + "e inc -457 if c != 1040\n" +
            "wnh inc 914 if tme < -279\n" + "tme inc -262 if c == 1050\n" + "c inc -611 if c == 1050\n" +
            "xml inc 921 if az >= 953\n" + "tme inc -910 if k > -2148\n" + "xml inc 994 if o >= 4452\n" +
            "c inc 433 if xbp == -612\n" + "wfu dec 591 if jyi == 1101\n" + "jyi dec -916 if wnh < -1045\n" +
            "eia dec -514 if jyi == 2007\n" + "tme dec -305 if o <= 4463\n" + "c dec -404 if baj <= -2076\n" +
            "rz dec -942 if wfu > 1501\n" + "xbp inc 286 if k == -2144\n" + "xbp inc -119 if fy >= 3743\n" +
            "ugc inc 171 if baj != -2074\n" + "l dec -784 if xbp < -443\n" + "ugc dec 146 if sqf < 3173\n" +
            "c dec 397 if c > 1272\n" + "k dec 468 if fy != 3743\n" + "wnh inc -174 if sz == 5145\n" +
            "u dec -225 if eia == -4284\n" + "sqf inc 687 if fy == 3743\n" + "e inc 705 if jyi == 2008\n" +
            "wfu inc -904 if c <= 887\n" + "jyi dec -593 if wfu <= 597\n" + "tme inc 807 if e < -1554\n" +
            "fy inc -497 if az > 946\n" + "rz inc -921 if sz == 5146\n" + "az dec -401 if wfu >= 591\n" +
            "sz dec 728 if k > -2149\n" + "c dec 884 if vke <= 2787\n" + "l dec 764 if vke <= 2804\n" +
            "xml dec 226 if b < 3346\n" + "sqf dec -84 if c < 879\n" + "eia inc 634 if e <= -1556\n" +
            "o inc -473 if az >= 1357\n" + "sb inc 917 if o == 3988\n" + "ugc inc 411 if tme >= -334\n" +
            "jyi inc 214 if az != 1353\n" + "xbp inc -296 if c <= 879\n" + "k inc -416 if sb < -3525\n" +
            "eia inc -847 if tme != -350\n" + "sb dec 525 if k <= -2139\n" + "sqf inc -749 if sz > 4415\n" +
            "c inc -382 if xbp != -749\n" + "l dec -705 if wfu < 594\n" + "sz dec 38 if xbp >= -739\n" +
            "sqf dec 431 if xbp != -733\n" + "b inc 766 if xbp >= -748\n" + "wfu inc -263 if tme != -341\n" +
            "wnh inc 435 if c != 494\n" + "sqf dec -207 if vke != 2807\n" + "sb inc -192 if sz < 4419\n" +
            "sb inc 985 if wfu > 319\n" + "wfu inc 478 if ugc != -2097\n" + "eia inc -44 if rz < 4042\n" +
            "u inc 457 if jyi >= 2818\n" + "sb inc 929 if sb == -3249\n" + "vke dec -199 if vke >= 2793\n" +
            "sqf dec -144 if u < -1656\n" + "sqf dec -917 if ugc == -2097\n" + "rz dec 958 if b == 4109\n" +
            "k inc -532 if vke <= 2996\n" + "y dec -150 if sqf <= 3804\n" + "jyi dec -149 if u == -1651\n" +
            "jyi dec 939 if wfu < 337\n" + "xml inc 266 if wnh <= -782\n" + "pp inc 130 if tme == -338\n" +
            "u inc 665 if xml > 4994\n" + "o inc -510 if tme >= -341\n" + "k dec -273 if sz != 4421\n" +
            "vke inc 392 if wnh < -778\n" + "pp dec -464 if wfu <= 334\n" + "xml dec 746 if xbp != -741\n" +
            "xml dec 215 if eia != -4541\n" + "b inc 26 if sz > 4420\n" + "wnh inc -601 if l != -1183\n" +
            "u dec -660 if xbp < -744\n" + "o dec -362 if xml < 5004\n" + "k dec 689 if y > 1924\n" +
            "ugc dec -245 if sb <= -2315\n" + "rz inc 746 if o >= 3835\n" + "sqf inc -65 if baj == -2078\n" +
            "xml dec -571 if az > 1365\n" + "xml inc -309 if wnh < -1379\n" + "wnh dec -554 if y == 1933\n" +
            "vke inc 542 if xbp == -741\n" + "e inc -386 if o == 3840\n" + "b inc -605 if c > 495\n" +
            "az inc -784 if sz <= 4426\n" + "pp inc 308 if sz < 4418\n" + "c dec -79 if eia < -4549\n" +
            "sb inc 224 if b >= 3497\n" + "rz dec 681 if az <= 578\n" + "ugc inc 210 if c <= 500\n" +
            "baj inc -271 if o < 3834\n" + "l inc 476 if sz < 4422\n" + "o dec -432 if tme >= -345\n" +
            "baj inc -713 if u < -982\n" + "u inc -192 if baj == -2791\n" + "baj dec 411 if wnh <= -833\n" +
            "pp dec 728 if y == 1933\n" + "ugc inc -200 if sb != -2096\n" + "l dec 787 if fy == 3252\n" +
            "pp dec -924 if rz >= 3136\n" + "o inc 792 if o <= 4280\n" + "b dec -300 if u < -1171\n" +
            "sqf dec -328 if az >= 580\n" + "vke dec 887 if baj >= -2799\n" + "u inc -252 if vke == 3050\n" +
            "o dec 640 if eia <= -4541\n" + "sb inc -919 if wnh >= -836\n" + "l dec 463 if wnh <= -841\n" +
            "rz dec -942 if b <= 3797\n" + "az dec -170 if fy <= 3253\n" + "e inc 718 if eia > -4545\n" +
            "az dec 103 if ugc <= -1650\n" + "sqf inc 709 if jyi > 1879\n" + "pp inc 566 if c == 502\n" +
            "e inc -611 if sz <= 4417\n" + "baj inc -998 if wfu != 328\n" + "o dec 891 if sqf < 4450\n" +
            "sz dec -86 if pp <= -143\n" + "xbp dec 199 if sz > 4411\n" + "rz inc -158 if c != 487\n" +
            "rz inc -710 if wfu > 324\n" + "ugc dec -635 if fy >= 3241\n" + "k inc -221 if az <= 738\n" +
            "sqf inc -74 if e > -1839\n" + "az dec -317 if az >= 743\n" + "eia dec 596 if tme <= -339\n" +
            "vke dec 708 if wnh == -832\n" + "u dec 414 if sz == 4417\n" + "y inc 388 if e < -1841\n" +
            "xml inc -783 if y == 1941\n" + "o dec 695 if c < 498\n" + "ugc dec -944 if baj != -2787\n" +
            "b inc -964 if baj <= -2787\n" + "vke dec -208 if sqf == 4373\n" + "vke inc -206 if rz >= 2274\n" +
            "ugc inc 726 if tme < -333\n" + "eia inc 986 if ugc < 667\n" + "baj dec -139 if vke < 2343\n" +
            "o dec -19 if eia != -4156\n" + "wnh inc -396 if sz > 4419\n" + "ugc inc -74 if rz >= 2277\n" +
            "pp inc 239 if wnh < -828\n" + "sz inc -741 if u == -1594\n" + "c inc 340 if k < -3089\n" +
            "xml dec 156 if sqf >= 4371\n" + "sqf dec 433 if b != 2841\n" + "vke dec 231 if tme < -334\n" +
            "u inc 393 if eia > -4150\n" + "xbp dec -482 if u >= -1599\n" + "fy inc 40 if u > -1601\n" +
            "baj dec 29 if sz <= 3684\n" + "sz dec 874 if xml != 4531\n" + "ugc inc -50 if pp <= 103\n" +
            "sb dec 96 if xbp == -458\n" + "e inc 266 if jyi != 1894\n" + "sz inc 336 if y == 1933\n" +
            "eia dec -592 if wfu > 321\n" + "rz dec -580 if o > 2863\n" + "xml dec -468 if l != -701\n" +
            "sqf inc -672 if sqf == 3940\n" + "vke dec -600 if jyi < 1891\n" + "e dec -31 if baj < -2677\n" +
            "rz dec -409 if rz != 2275\n" + "jyi inc 839 if ugc > 536\n" + "wfu inc -886 if c > 830\n" +
            "vke inc 500 if l == -708\n" + "sz inc 490 if tme >= -344\n" + "rz inc -478 if rz != 2684\n" +
            "sqf inc -367 if o != 2853\n" + "baj inc -461 if u <= -1585\n" + "fy dec -642 if c <= 827\n" +
            "ugc inc -371 if b > 2836\n" + "l inc -983 if jyi <= 2727\n" + "b dec 599 if wfu <= -565\n" +
            "rz inc -852 if baj <= -3149\n" + "sz dec -453 if c != 827\n" + "vke inc 631 if jyi < 2725\n" +
            "b inc 145 if xml >= 4996\n" + "sqf inc -921 if ugc == 168\n" + "c inc 933 if xml < 5002\n" +
            "l dec 994 if y <= 1934\n" + "eia dec 59 if wnh <= -828\n" + "wfu dec 600 if ugc >= 166\n" +
            "b dec -316 if az > 1050\n" + "sz dec 832 if y < 1940\n" + "fy dec -517 if fy >= 3280\n" +
            "c inc -801 if jyi <= 2727\n" + "xbp dec 381 if xml < 5007\n" + "rz dec 115 if baj >= -3142\n" +
            "az inc -553 if tme > -332\n" + "wfu inc 837 if rz <= 2093\n" + "ugc inc -490 if tme <= -334\n" +
            "fy inc 645 if xbp >= -843\n" + "tme inc -756 if tme >= -341\n" + "rz inc -987 if e != -1543\n" +
            "xml inc -423 if jyi > 2715\n" + "rz inc 985 if c <= 975\n" + "ugc inc -698 if o > 2847\n" +
            "rz dec 498 if l <= -2684\n" + "baj dec -826 if xbp != -845\n" + "k inc 829 if o >= 2849\n" +
            "xbp inc 632 if az == 1060\n" + "ugc inc 778 if baj >= -2321\n" + "y inc -806 if sz == 3249\n" +
            "baj dec -91 if y != 1120\n" + "xml dec 932 if fy == 4448\n" + "fy inc -682 if xbp != -207\n" +
            "eia inc -640 if u > -1602\n" + "l inc -736 if baj == -2225\n" + "xbp inc 244 if l >= -3429\n" +
            "pp inc 26 if sqf < 1974\n" + "wfu inc -465 if e != -1541\n" + "e dec -224 if l != -3426\n" +
            "wfu dec 424 if sb > -3117\n" + "wfu inc 699 if u > -1597\n" + "ugc dec -222 if b > 3298\n" +
            "c dec 57 if c > 967\n" + "e inc 318 if fy > 4440\n" + "jyi dec -93 if pp != 102\n" +
            "jyi inc 71 if xbp < 34\n" + "pp inc 598 if xbp <= 42\n" + "az inc 143 if wnh == -832\n" +
            "xml dec 13 if baj > -2227\n" + "ugc inc -643 if az >= 1200";

    public Day08() {
        System.out.println("\n--- Day 8: I Heard You Like Registers ---");
        // input
        List<RegisterInstruction> regInstr = (List<RegisterInstruction>) parseInputLines(Return.REG_INSTR);
        // wörk
        // TODO: 09.12.2017 work with input

        System.out.println();
        // finished
    }

    public static void main(String[] args) {
        new Day08();
    }

    @NotNull
    @Override
    String getDefaultInput() {
        return myInput;
    }
}
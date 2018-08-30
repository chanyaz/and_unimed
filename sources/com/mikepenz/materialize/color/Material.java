package com.mikepenz.materialize.color;

import android.graphics.Color;
import com.mikepenz.materialize.e;

public class Material {

    public enum Amber implements IColor {
        _50("#FFF8E1", e.md_amber_50),
        _100("#FFECB3", e.md_amber_100),
        _200("#FFE082", e.md_amber_200),
        _300("#FFD54F", e.md_amber_300),
        _400("#FFCA28", e.md_amber_400),
        _500("#FFCA28", e.md_amber_500),
        _600("#FFB300", e.md_amber_600),
        _700("#FFA000", e.md_amber_700),
        _800("#FF8F00", e.md_amber_800),
        _900("#FF6F00", e.md_amber_900),
        _A100("#FFE57F", e.md_amber_A100),
        _A200("#FFD740", e.md_amber_A200),
        _A400("#FFC400", e.md_amber_A400),
        _A700("#FFAB00", e.md_amber_A700);
        
        String o;
        int p;

        private Amber(String str, int i) {
            this.o = str;
            this.p = i;
        }

        public int getAsColor() {
            return Color.parseColor(this.o);
        }

        public int getAsResource() {
            return this.p;
        }

        public String getAsString() {
            return this.o;
        }
    }

    public enum Black implements IColor {
        _1000("#000000", e.md_black_1000);
        
        String b;
        int c;

        private Black(String str, int i) {
            this.b = str;
            this.c = i;
        }

        public int getAsColor() {
            return Color.parseColor(this.b);
        }

        public int getAsResource() {
            return this.c;
        }

        public String getAsString() {
            return this.b;
        }
    }

    public enum Blue implements IColor {
        _50("#E3F2FD", e.md_blue_50),
        _100("#BBDEFB", e.md_blue_100),
        _200("#90CAF9", e.md_blue_200),
        _300("#64B5F6", e.md_blue_300),
        _400("#42A5F5", e.md_blue_400),
        _500("#2196F3", e.md_blue_500),
        _600("#1E88E5", e.md_blue_600),
        _700("#1976D2", e.md_blue_700),
        _800("#1565C0", e.md_blue_800),
        _900("#0D47A1", e.md_blue_900),
        _A100("#82B1FF", e.md_blue_A100),
        _A200("#448AFF", e.md_blue_A200),
        _A400("#2979FF", e.md_blue_A400),
        _A700("#2962FF", e.md_blue_A700);
        
        String o;
        int p;

        private Blue(String str, int i) {
            this.o = str;
            this.p = i;
        }

        public int getAsColor() {
            return Color.parseColor(this.o);
        }

        public int getAsResource() {
            return this.p;
        }

        public String getAsString() {
            return this.o;
        }
    }

    public enum BlueGrey implements IColor {
        _50("#ECEFF1", e.md_blue_grey_50),
        _100("#CFD8DC", e.md_blue_grey_100),
        _200("#B0BEC5", e.md_blue_grey_200),
        _300("#90A4AE", e.md_blue_grey_300),
        _400("#78909C", e.md_blue_grey_400),
        _500("#607D8B", e.md_blue_grey_500),
        _600("#546E7A", e.md_blue_grey_600),
        _700("#455A64", e.md_blue_grey_700),
        _800("#37474F", e.md_blue_grey_800),
        _900("#263238", e.md_blue_grey_900);
        
        String k;
        int l;

        private BlueGrey(String str, int i) {
            this.k = str;
            this.l = i;
        }

        public int getAsColor() {
            return Color.parseColor(this.k);
        }

        public int getAsResource() {
            return this.l;
        }

        public String getAsString() {
            return this.k;
        }
    }

    public enum Brown implements IColor {
        _50("#EFEBE9", e.md_brown_50),
        _100("#D7CCC8", e.md_brown_100),
        _200("#BCAAA4", e.md_brown_200),
        _300("#A1887F", e.md_brown_300),
        _400("#8D6E63", e.md_brown_400),
        _500("#795548", e.md_brown_500),
        _600("#6D4C41", e.md_brown_600),
        _700("#5D4037", e.md_brown_700),
        _800("#4E342E", e.md_brown_800),
        _900("#3E2723", e.md_brown_900);
        
        String k;
        int l;

        private Brown(String str, int i) {
            this.k = str;
            this.l = i;
        }

        public int getAsColor() {
            return Color.parseColor(this.k);
        }

        public int getAsResource() {
            return this.l;
        }

        public String getAsString() {
            return this.k;
        }
    }

    public enum Cyan implements IColor {
        _50("#E0F7FA", e.md_cyan_50),
        _100("#B2EBF2", e.md_cyan_100),
        _200("#80DEEA", e.md_cyan_200),
        _300("#4DD0E1", e.md_cyan_300),
        _400("#26C6DA", e.md_cyan_400),
        _500("#00BCD4", e.md_cyan_500),
        _600("#00ACC1", e.md_cyan_600),
        _700("#0097A7", e.md_cyan_700),
        _800("#00838F", e.md_cyan_800),
        _900("#006064", e.md_cyan_900),
        _A100("#84FFFF", e.md_cyan_A100),
        _A200("#18FFFF", e.md_cyan_A200),
        _A400("#00E5FF", e.md_cyan_A400),
        _A700("#00B8D4", e.md_cyan_A700);
        
        String o;
        int p;

        private Cyan(String str, int i) {
            this.o = str;
            this.p = i;
        }

        public int getAsColor() {
            return Color.parseColor(this.o);
        }

        public int getAsResource() {
            return this.p;
        }

        public String getAsString() {
            return this.o;
        }
    }

    public enum DeepOrange implements IColor {
        _50("#FBE9E7", e.md_deep_orange_50),
        _100("#FFCCBC", e.md_deep_orange_100),
        _200("#FFAB91", e.md_deep_orange_200),
        _300("#FF8A65", e.md_deep_orange_300),
        _400("#FF7043", e.md_deep_orange_400),
        _500("#FF5722", e.md_deep_orange_500),
        _600("#F4511E", e.md_deep_orange_600),
        _700("#E64A19", e.md_deep_orange_700),
        _800("#D84315", e.md_deep_orange_800),
        _900("#BF360C", e.md_deep_orange_900),
        _A100("#FF6E40", e.md_deep_orange_A100),
        _A200("#FFAB40", e.md_deep_orange_A200),
        _A400("#FF3D00", e.md_deep_orange_A400),
        _A700("#DD2C00", e.md_deep_orange_A700);
        
        String o;
        int p;

        private DeepOrange(String str, int i) {
            this.o = str;
            this.p = i;
        }

        public int getAsColor() {
            return Color.parseColor(this.o);
        }

        public int getAsResource() {
            return this.p;
        }

        public String getAsString() {
            return this.o;
        }
    }

    public enum DeepPurple implements IColor {
        _50("#EDE7F6", e.md_purple_50),
        _100("#D1C4E9", e.md_purple_100),
        _200("#B39DDB", e.md_purple_200),
        _300("#9575CD", e.md_purple_300),
        _400("#7E57C2", e.md_purple_400),
        _500("#673AB7", e.md_purple_500),
        _600("#5E35B1", e.md_purple_600),
        _700("#512DA8", e.md_purple_700),
        _800("#4527A0", e.md_purple_800),
        _900("#311B92", e.md_purple_900),
        _A100("#B388FF", e.md_purple_A100),
        _A200("#7C4DFF", e.md_purple_A200),
        _A400("#651FFF", e.md_purple_A400),
        _A700("#6200EA", e.md_purple_A700);
        
        String o;
        int p;

        private DeepPurple(String str, int i) {
            this.o = str;
            this.p = i;
        }

        public int getAsColor() {
            return Color.parseColor(this.o);
        }

        public int getAsResource() {
            return this.p;
        }

        public String getAsString() {
            return this.o;
        }
    }

    public class Elements {

        public enum Dark implements IColor {
            ICON("#8AFFFFFF", e.md_dark_primary_icon),
            TEXT("#DEFFFFFF", e.md_dark_primary_text),
            SECONDARY_TEXT("#8AFFFFFF", e.md_dark_secondary),
            SECONDARY_ICON("#8AFFFFFF", e.md_dark_secondary),
            DISABLED_TEXT("#42FFFFFF", e.md_dark_disabled),
            HINT_TEXT("#42FFFFFF", e.md_dark_disabled),
            DIVIDER("#1FFFFFFF", e.md_dark_dividers);
            
            String h;
            int i;

            private Dark(String str, int i) {
                this.h = str;
                this.i = i;
            }

            public int getAsColor() {
                return Color.parseColor(this.h);
            }

            public int getAsResource() {
                return this.i;
            }

            public String getAsString() {
                return this.h;
            }
        }

        public enum Light implements IColor {
            ICON("#8A000000", e.md_light_primary_icon),
            TEXT("#DE000000", e.md_light_primary_text),
            SECONDARY_TEXT("#8A000000", e.md_light_secondary),
            SECONDARY_ICON("#8A000000", e.md_light_secondary),
            DISABLED_TEXT("#42000000", e.md_light_disabled),
            HINT_TEXT("#42000000", e.md_light_disabled),
            DIVIDER("#1F000000", e.md_light_dividers);
            
            String h;
            int i;

            private Light(String str, int i) {
                this.h = str;
                this.i = i;
            }

            public int getAsColor() {
                return Color.parseColor(this.h);
            }

            public int getAsResource() {
                return this.i;
            }

            public String getAsString() {
                return this.h;
            }
        }
    }

    public enum Green implements IColor {
        _50("#E8F5E9", e.md_green_50),
        _100("#C8E6C9", e.md_green_100),
        _200("#A5D6A7", e.md_green_200),
        _300("#81C784", e.md_green_300),
        _400("#66BB6A", e.md_green_400),
        _500("#4CAF50", e.md_green_500),
        _600("#43A047", e.md_green_600),
        _700("#388E3C", e.md_green_700),
        _800("#2E7D32", e.md_green_800),
        _900("#1B5E20", e.md_green_900),
        _A100("#B9F6CA", e.md_green_A100),
        _A200("#69F0AE", e.md_green_A200),
        _A400("#00E676", e.md_green_A400),
        _A700("#00C853", e.md_green_A700);
        
        String o;
        int p;

        private Green(String str, int i) {
            this.o = str;
            this.p = i;
        }

        public int getAsColor() {
            return Color.parseColor(this.o);
        }

        public int getAsResource() {
            return this.p;
        }

        public String getAsString() {
            return this.o;
        }
    }

    public enum Grey implements IColor {
        _50("#FAFAFA", e.md_grey_50),
        _100("#F5F5F5", e.md_grey_100),
        _200("#EEEEEE", e.md_grey_200),
        _300("#E0E0E0", e.md_grey_300),
        _400("#BDBDBD", e.md_grey_400),
        _500("#9E9E9E", e.md_grey_500),
        _600("#757575", e.md_grey_600),
        _700("#616161", e.md_grey_700),
        _800("#424242", e.md_grey_800),
        _900("#212121", e.md_grey_900);
        
        String k;
        int l;

        private Grey(String str, int i) {
            this.k = str;
            this.l = i;
        }

        public int getAsColor() {
            return Color.parseColor(this.k);
        }

        public int getAsResource() {
            return this.l;
        }

        public String getAsString() {
            return this.k;
        }
    }

    public enum Indigo implements IColor {
        _50("#E8EAF6", e.md_indigo_50),
        _100("#C5CAE9", e.md_indigo_100),
        _200("#9FA8DA", e.md_indigo_200),
        _300("#7986CB", e.md_indigo_300),
        _400("#5C6BC0", e.md_indigo_400),
        _500("#3F51B5", e.md_indigo_500),
        _600("#3949AB", e.md_indigo_600),
        _700("#303F9F", e.md_indigo_700),
        _800("#283593", e.md_indigo_800),
        _900("#1A237E", e.md_indigo_900),
        _A100("#8C9EFF", e.md_indigo_A100),
        _A200("#536DFE", e.md_indigo_A200),
        _A400("#3D5AFE", e.md_indigo_A400),
        _A700("#304FFE", e.md_indigo_A700);
        
        String o;
        int p;

        private Indigo(String str, int i) {
            this.o = str;
            this.p = i;
        }

        public int getAsColor() {
            return Color.parseColor(this.o);
        }

        public int getAsResource() {
            return this.p;
        }

        public String getAsString() {
            return this.o;
        }
    }

    public enum LightBlue implements IColor {
        _50("#E1F5FE", e.md_light_blue_50),
        _100("#B3E5FC", e.md_light_blue_100),
        _200("#81D4FA", e.md_light_blue_200),
        _300("#4FC3F7", e.md_light_blue_300),
        _400("#29B6F6", e.md_light_blue_400),
        _500("#03A9F4", e.md_light_blue_500),
        _600("#039BE5", e.md_light_blue_600),
        _700("#0288D1", e.md_light_blue_700),
        _800("#0277BD", e.md_light_blue_800),
        _900("#01579B", e.md_light_blue_900),
        _A100("#80D8FF", e.md_light_blue_A100),
        _A200("#40C4FF", e.md_light_blue_A200),
        _A400("#00B0FF", e.md_light_blue_A400),
        _A700("#0091EA", e.md_light_blue_A700);
        
        String o;
        int p;

        private LightBlue(String str, int i) {
            this.o = str;
            this.p = i;
        }

        public int getAsColor() {
            return Color.parseColor(this.o);
        }

        public int getAsResource() {
            return this.p;
        }

        public String getAsString() {
            return this.o;
        }
    }

    public enum LightGreen implements IColor {
        _50("#F1F8E9", e.md_light_green_50),
        _100("#DCEDC8", e.md_light_green_100),
        _200("#C5E1A5", e.md_light_green_200),
        _300("#AED581", e.md_light_green_300),
        _400("#9CCC65", e.md_light_green_400),
        _500("#8BC34A", e.md_light_green_500),
        _600("#7CB342", e.md_light_green_600),
        _700("#689F38", e.md_light_green_700),
        _800("#558B2F", e.md_light_green_800),
        _900("#33691E", e.md_light_green_900),
        _A100("#CCFF90", e.md_light_green_A100),
        _A200("#B2FF59", e.md_light_green_A200),
        _A400("#76FF03", e.md_light_green_A400),
        _A700("#64DD17", e.md_light_green_A700);
        
        String o;
        int p;

        private LightGreen(String str, int i) {
            this.o = str;
            this.p = i;
        }

        public int getAsColor() {
            return Color.parseColor(this.o);
        }

        public int getAsResource() {
            return this.p;
        }

        public String getAsString() {
            return this.o;
        }
    }

    public enum Lime implements IColor {
        _50("#F9FBE7", e.md_lime_50),
        _100("#F0F4C3", e.md_lime_100),
        _200("#E6EE9C", e.md_lime_200),
        _300("#DCE775", e.md_lime_300),
        _400("#D4E157", e.md_lime_400),
        _500("#CDDC39", e.md_lime_500),
        _600("#C0CA33", e.md_lime_600),
        _700("#AFB42B", e.md_lime_700),
        _800("#9E9D24", e.md_lime_800),
        _900("#827717", e.md_lime_900),
        _A100("#F4FF81", e.md_lime_A100),
        _A200("#EEFF41", e.md_lime_A200),
        _A400("#C6FF00", e.md_lime_A400),
        _A700("#AEEA00", e.md_lime_A700);
        
        String o;
        int p;

        private Lime(String str, int i) {
            this.o = str;
            this.p = i;
        }

        public int getAsColor() {
            return Color.parseColor(this.o);
        }

        public int getAsResource() {
            return this.p;
        }

        public String getAsString() {
            return this.o;
        }
    }

    public enum Orange implements IColor {
        _50("#FFF3E0", e.md_orange_50),
        _100("#FFE0B2", e.md_orange_100),
        _200("#FFCC80", e.md_orange_200),
        _300("#FFB74D", e.md_orange_300),
        _400("#FFA726", e.md_orange_400),
        _500("#FF9800", e.md_orange_500),
        _600("#FB8C00", e.md_orange_600),
        _700("#F57C00", e.md_orange_700),
        _800("#EF6C00", e.md_orange_800),
        _900("#E65100", e.md_orange_900),
        _A100("#FFD180", e.md_orange_A100),
        _A200("#FFAB40", e.md_orange_A200),
        _A400("#FF9100", e.md_orange_A400),
        _A700("#FF6D00", e.md_orange_A700);
        
        String o;
        int p;

        private Orange(String str, int i) {
            this.o = str;
            this.p = i;
        }

        public int getAsColor() {
            return Color.parseColor(this.o);
        }

        public int getAsResource() {
            return this.p;
        }

        public String getAsString() {
            return this.o;
        }
    }

    public enum Pink implements IColor {
        _50("#E91E63", e.md_pink_50),
        _100("#F8BBD0", e.md_pink_100),
        _200("#F48FB1", e.md_pink_200),
        _300("#F06292", e.md_pink_300),
        _400("#EC407A", e.md_pink_400),
        _500("#E91E63", e.md_pink_500),
        _600("#D81B60", e.md_pink_600),
        _700("#C2185B", e.md_pink_700),
        _800("#AD1457", e.md_pink_800),
        _900("#880E4F", e.md_pink_900),
        _A100("#FF80AB", e.md_pink_A100),
        _A200("#FF4081", e.md_pink_A200),
        _A400("#F50057", e.md_pink_A400),
        _A700("#C51162", e.md_pink_A700);
        
        String o;
        int p;

        private Pink(String str, int i) {
            this.o = str;
            this.p = i;
        }

        public int getAsColor() {
            return Color.parseColor(this.o);
        }

        public int getAsResource() {
            return this.p;
        }

        public String getAsString() {
            return this.o;
        }
    }

    public enum Purple implements IColor {
        _50("#F3E5F5", e.md_purple_50),
        _100("#E1BEE7", e.md_purple_100),
        _200("#CE93D8", e.md_purple_200),
        _300("#BA68C8", e.md_purple_300),
        _400("#AB47BC", e.md_purple_400),
        _500("#9C27B0", e.md_purple_500),
        _600("#8E24AA", e.md_purple_600),
        _700("#7B1FA2", e.md_purple_700),
        _800("#6A1B9A", e.md_purple_800),
        _900("#4A148C", e.md_purple_900),
        _A100("#EA80FC", e.md_purple_A100),
        _A200("#E040FB", e.md_purple_A200),
        _A400("#D500F9", e.md_purple_A400),
        _A700("#AA00FF", e.md_purple_A700);
        
        String o;
        int p;

        private Purple(String str, int i) {
            this.o = str;
            this.p = i;
        }

        public int getAsColor() {
            return Color.parseColor(this.o);
        }

        public int getAsResource() {
            return this.p;
        }

        public String getAsString() {
            return this.o;
        }
    }

    public enum Red implements IColor {
        _50("#FFEBEE", e.md_red_50),
        _100("#FFCDD2", e.md_red_100),
        _200("#EF9A9A", e.md_red_200),
        _300("#E57373", e.md_red_300),
        _400("#EF5350", e.md_red_400),
        _500("#F44336", e.md_red_500),
        _600("#E53935", e.md_red_600),
        _700("#D32F2F", e.md_red_700),
        _800("#C62828", e.md_red_800),
        _900("#B71C1C", e.md_red_900),
        _A100("#FF8A80", e.md_red_A100),
        _A200("#FF5252", e.md_red_A200),
        _A400("#FF1744", e.md_red_A400),
        _A700("#D50000", e.md_red_A700);
        
        String o;
        int p;

        private Red(String str, int i) {
            this.o = str;
            this.p = i;
        }

        public int getAsColor() {
            return Color.parseColor(this.o);
        }

        public int getAsResource() {
            return this.p;
        }

        public String getAsString() {
            return this.o;
        }
    }

    public enum Teal implements IColor {
        _50("#E0F2F1", e.md_teal_50),
        _100("#B2DFDB", e.md_teal_100),
        _200("#80CBC4", e.md_teal_200),
        _300("#4DB6AC", e.md_teal_300),
        _400("#26A69A", e.md_teal_400),
        _500("#009688", e.md_teal_500),
        _600("#00897B", e.md_teal_600),
        _700("#00796B", e.md_teal_700),
        _800("#00695C", e.md_teal_800),
        _900("#004D40", e.md_teal_900),
        _A100("#A7FFEB", e.md_teal_A100),
        _A200("#64FFDA", e.md_teal_A200),
        _A400("#1DE9B6", e.md_teal_A400),
        _A700("#00BFA5", e.md_teal_A700);
        
        String o;
        int p;

        private Teal(String str, int i) {
            this.o = str;
            this.p = i;
        }

        public int getAsColor() {
            return Color.parseColor(this.o);
        }

        public int getAsResource() {
            return this.p;
        }

        public String getAsString() {
            return this.o;
        }
    }

    public enum White implements IColor {
        _1000("#FFFFFF", e.md_white_1000);
        
        String b;
        int c;

        private White(String str, int i) {
            this.b = str;
            this.c = i;
        }

        public int getAsColor() {
            return Color.parseColor(this.b);
        }

        public int getAsResource() {
            return this.c;
        }

        public String getAsString() {
            return this.b;
        }
    }

    public enum Yellow implements IColor {
        _50("#FFFDE7", e.md_yellow_50),
        _100("#FFF9C4", e.md_yellow_100),
        _200("#FFF59D", e.md_yellow_200),
        _300("#FFF176", e.md_yellow_300),
        _400("#FFEE58", e.md_yellow_400),
        _500("#FFEB3B", e.md_yellow_500),
        _600("#FDD835", e.md_yellow_600),
        _700("#FBC02D", e.md_yellow_700),
        _800("#F9A825", e.md_yellow_800),
        _900("#F57F17", e.md_yellow_900),
        _A100("#FFFF8D", e.md_yellow_A100),
        _A200("#FFFF00", e.md_yellow_A200),
        _A400("#FFEA00", e.md_yellow_A400),
        _A700("#FFD600", e.md_yellow_A700);
        
        String o;
        int p;

        private Yellow(String str, int i) {
            this.o = str;
            this.p = i;
        }

        public int getAsColor() {
            return Color.parseColor(this.o);
        }

        public int getAsResource() {
            return this.p;
        }

        public String getAsString() {
            return this.o;
        }
    }
}

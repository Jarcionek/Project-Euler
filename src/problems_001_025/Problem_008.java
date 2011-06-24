package problems_001_025;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_008 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String x = "731671765313306249192251196744265747423553491949349698352" +
                "031277450632623957831801698480186947885184385861560789112949" +
                "495459501737958331952853208805511125406987471585238630507156" +
                "932909632952274430435576689664895044524452316173185640309871" +
                "112172238311362229893423380308135336276614282806444486645238" +
                "749303589072962904915604407723907138105158593079608667017242" +
                "712188399879790879227492190169972088809377665727333001053367" +
                "881220235421809751254540594752243525849077116705560136048395" +
                "864467063244157221553975369781797784617406495514929086256932" +
                "197846862248283972241375657056057490261407972968652414535100" +
                "474821663704844031998900088952434506585412275886668811642717" +
                "147992444292823086346567481391912316282458617866458359124566" +
                "529476545682848912883142607690042242190226710556263211111093" +
                "705442175069416589604080719840385096245544436298123098787992" +
                "724428490918884580156166097919133875499200524063689912560717" +
                "606058861164671094050775410022569831552000559357297257163626" +
                "9561882670428252483600823257530420752963450";
        int max = 0;
        for (int i = 0; i <= 995; i++) {
            int temp = 1;
            for (int j = 0; j < 5; j++) {
                temp *= (int) x.charAt(i+j) - 48;
            }
            if (temp > max) {
                max = temp;
            }
        }
        System.out.println(max);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
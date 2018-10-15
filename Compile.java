import java.util.ArrayList;
import io.Reader;
import io.Writer;
import io.ErrorHandler;
import depurate.Depurator;
import depurate.Line;
import analyser.Analyser;
import lexeme.LexemeTable;
import lexeme.VariablesTable;

class Compile {
  public static void main(String[] args) {
    compile(args[0]);
  }

  public static void compile(String name) {
    Depurator.depurate(name);

    ArrayList<Line> lines = Line.getLines();

    System.out.println("\nLINEAS A COMPILAR");
    for (Line ln: lines) {
      System.out.println(ln.getDepuredLine());
    }
    System.out.println();

    for (Line line: lines) {
      Analyser.Analyse(line);
      System.out.println();
    }
    analyser.Stack.getInstance().remainings();

    LexemeTable.getInstance().printTable();
    VariablesTable.getInstance().printTable();
    ErrorHandler.printErrors();
    //Viking();
  }

  public static void Viking() {
    System.out.println("                                                      `                                                 ");
    System.out.println("                                                -sho`                                               ");
    System.out.println("                                              `oo.+:h:                                              ");
    System.out.println("                                             -s---`:.os`                                            ");
    System.out.println("                                     `--:-//shs:-   +:sds+:--.`                                     ");
    System.out.println("                                 `-::/:::--:+dd`-. :: hms+/:.`.---`                                 ");
    System.out.println("                               -:::`.``      .h: ::: -y.       .:::/:`                              ");
    System.out.println("                             .--+/`           :s  o  o.         `.-`-o+`                            ");
    System.out.println("                        .--.:.-:`             `y  +  +               :sy-..`                        ");
    System.out.println("                     `+sysoss``                h  +  /                :hyo+oo+`                     ");
    System.out.println("               `--://sdo.``-:/                 h  /  /                 o:.`.ooy//:-.`               ");
    System.out.println("           .:+ssssoo/.+o     o                 h  /  +                /.    oy/++ooooo/-`           ");
    System.out.println("        `:+oos+:--...  /.    /`               -s  :  s                s    `s.:-.--:/++oo+-         ");
    System.out.println("      `/ooo:.           +   `/.               +/ `:  s.               s.   o.         .-/+oo-       ");
    System.out.println("     .soo:`             -+`.+o-               h. `:  /o              `s/s-+o             .:+o+`     ");
    System.out.println("    :d++`         `.-::. mdm/h:              /y `/+. `d.             `h:mmm/`.--.`         `/+s`    ");
    System.out.println("   .m+/        ./yhmmmmm:mmm-ms             .d:.:``/- sy             -m.dmm+smmmmhs:`        -/s    ");
    System.out.println("   om``     `:ymmmmmmmmd+mmosmm-            od+-    :osm`           `yms+mmh/mmmmmmmd+`       `+/   ");
    System.out.println("   yy+     .smmmmddhyyy+hdy+mmmd-           od::    `shm`          -hmmm+ydd+oyyhhdmmmd:       -y   ");
    System.out.println("   shh    `hmmds+oo+/+mmdyymmmmmms-`       .hd::    :/mms.      `-smmmmmmysymm+/+osssdmm/      .y   ");
    System.out.println("   :mo.   +mdy/so-   /mmmmy//+osyhhys+//+oohddo:    +:mmdhs+//+sydhhyso+/ommmh.   `:oosmm.     /+   ");
    System.out.println("    sso   ohh:d/      -+sddy+/:--......------/y:    +-h.........````.-:/oymh/.       +som+   `:y`   ");
    System.out.println("    `so/  /mhoy        `-+/dsmmmmmdo//:::::+yhh:    +-mo+-------:odmmmmm+.+m:         d.m+  .os.    ");
    System.out.println("      +s:  yd+y       /yy++.:sd+oydmho+//+smmms/    /`mmm+---:+ydmmds:+m+ +ydo.      `y/d``:so`     ");
    System.out.println("       .o/``soy-       +`  . +y    `-:/ommmmmh/:    :`yhmmmmdhys+:.   :d` +y-.       s/y.-+s:       ");
    System.out.println("         -+: +/y   ``-/-/-  .my    `-/oyys+:`o:`    `:/`./shy+-`      omh:`ys.      :s+./s/         ");
    System.out.println("           -o.:+-  .+syds  .+sd             ./-      :`/      `.`    -mh/+hdh+`     h/.s+`          ");
    System.out.println("             //-/    -/.  .: /ho            o+.      -/s`           -dhy.  /y-     `s.o`            ");
    System.out.println("              -o.  `sdy  /+  / mo`       .:+do.--  --.omo-`       `om/  -` .ymdo:  `o/              ");
    System.out.println("               /   /-+s:hs  .`:m+h+.  -ohs:.`.ss`-/`+y/::+sy/` ./om+.y+  `  .m:`    /               ");
    System.out.println("                    -dymy`   .h. y-hdmmo`   -+ydd+sss+/-` .-odmmy `-` yy`  ` /y                     ");
    System.out.println("                    +`hd:`  -h. :- omm/`:o+/-` -ymm/.///ss:`-smmm/    .hd/h++ods/`                  ");
    System.out.println("                     :msy+ :h.  + `dd/-hd++++oss/`-+oyhmmmmd/`+mdoo    ydhm:  `.                    ");
    System.out.println("                     // sosd.  :` ++s.hmhymsss/-...-/soydhymmh-:m+:o`  :ms+y/                       ");
    System.out.println("                     `.smmm:  `` `/m.+m+/m+ -o-h+/h+:m- `y/smys-sd -y`  yd:.:`                      ");
    System.out.println("                     -/ommy     -ohy`h-:md` `  o  .s o/  .y`h.y//m/ /do:-sd+                        ");
    System.out.println("                       hmmo   :s/.m:-.:dmo  .- s   h`+/ -`m -`-/.dd. dy++oyd`                       ");
    System.out.println("                       doh+`:yh.`yh .++yd:-`o+ d   y:y+`d/d-   - :mh-+h    +`                       ");
    System.out.println("                       o`dss/h:`ym+/:.omhy++sh.h:  y+dysmmmy`  +` omdymo   `                        ");
    System.out.println("                       `-s:``d-dms-`-ommsyyd-:syd` hymdmodms-  :d/.d/mho:                           ");
    System.out.println("                            `dhm/  /:s/h+`ym- .smo ddm/d-ody//``hmhdhd+                             ");
    System.out.println("                             ysh `+:-s`m/ `hs  `hm:d/m:: /+y:mdoymos/y/                             ");
    System.out.println("                             -ds+yh.hohh`  -m`. syds`d: `+-d:hh``/+`  `                             ");
    System.out.println("                             :/-.oh/+mm+oss:m-/:s.m+ y-`ss:m+oy   `                                 ");
    System.out.println("                                 +- `ymd.`/ddyhd` d/ y:yhdym. .`                                    ");
    System.out.println("                                     `+h:  odddd//dyodh/`.odo                                       ");
    System.out.println("                                       `.  .+hoossyosyh+   -s                                       ");
    System.out.println("                                            :ysyyyyyyyh+                                            ");
    System.out.println("                                            `sh+oyyddss                                             ");
    System.out.println("                                           .sm-  .`hd`s                                             ");
    System.out.println("                                          /dmd`. `.`dss`                                            ");
    System.out.println("                                         `::od/.  / /mds`                                           ");
    System.out.println("                                             ds- `+ +hys:                                           ");
    System.out.println("                                            .mh+`ys.d.                                              ");
    System.out.println("                                            +o-hshhd/                                               ");
    System.out.println("                                            .  sy/+d`                                               ");
    System.out.println("                                               /` :-`                                               ");
  }
}

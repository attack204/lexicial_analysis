package grammar;

import grammar.V.*;
import lombok.Getter;
import wordanalyzer.words.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;

//文法
public class Grammar {
    //产生式
    @Getter
    private static final ArrayList<NTChar> G = new ArrayList<>();

    //文法符号集
    @Getter
    private static final LinkedHashSet<Char> X = new LinkedHashSet<>();

    static {
        //S→O
        G.add(new S().a(new O()));
        //O→F
        G.add(new O().a(new F()));
        //O→OF
        G.add(new O().a(new O()).a(new F()));
        //F→TNXA
        G.add(new F().a(new T()).a(new N()).a(new X()).a(new A()));
        //T→<float>
        G.add(new T().a(new FLOAT()));
        //T→<int>
        G.add(new T().a(new INT()));
        //T→<string>
        G.add(new T().a(new STRING()));
        //T→<bool>
        G.add(new T().a(new BOOL()));
        //N→<main>
        G.add(new N().a(new MAIN()));
        //N→<ID>
        G.add(new N().a(new ID()));
        //X→()
        G.add(new X().a(new XKH_L()).a(new XKH_R()));
        //X→(T<ID>)
        G.add(new X().a(new XKH_L()).a(new T()).a(new ID()).a(new XKH_R()));
        //A→{}
        G.add(new A().a(new DKH_L()).a(new DKH_R()));
        //A→{L}
        G.add(new A().a(new DKH_L()).a(new L()).a(new DKH_R()));
        //L→Y
        G.add(new L().a(new Y()));
        //L→LY
        G.add(new L().a(new L()).a(new Y()));
        //Y→D
        G.add(new Y().a(new D()));
        //Y→Z
        G.add(new Y().a(new Z()));
        //Y→I
        G.add(new Y().a(new I()));
        //Y→W
        G.add(new Y().a(new W()));
        //Y→R
        G.add(new Y().a(new R()));
        //D→T<ID><;>
        G.add(new D().a(new T()).a(new ID()).a(new SEMICOLON()));
        //Z→B
        G.add(new Z().a(new B()));
        //Z→TB
        G.add(new Z().a(new T()).a(new B()));
        //B→<ID>=E<;>
        G.add(new B().a(new ID()).a(new ASSIGN()).a(new E()).a(new SEMICOLON()));
        //E→(E)
        G.add(new E().a(new XKH_L()).a(new E()).a(new XKH_R()));
        //E→V
        G.add(new E().a(new V()));
        //E→EGE
        G.add(new E().a(new E()).a(new G()).a(new E()));
        //V→<ID>
        G.add(new V().a(new ID()));
        //V→C
        G.add(new V().a(new C()));
        //C→<float_value>
        G.add(new C().a(new FLOAT_VALUE()));
        //C→<int_value>
        G.add(new C().a(new INT_VALUE()));
        //C→<string_value>
        G.add(new C().a(new STRING_VALUE()));
        //C→<bool_value>
        G.add(new C().a(new BOOL_VALUE()));
        //G→+
        G.add(new G().a(new ADD()));
        //G→-
        G.add(new G().a(new SUBTRACT()));
        //G→*
        G.add(new G().a(new MULTIPLY()));
        //G→/
        G.add(new G().a(new DIVIDE()));
        //I→J
        G.add(new I().a(new J()));
        //I→K
        G.add(new I().a(new K()));
        //J→<if>(P)A
        G.add(new J().a(new IF()).a(new XKH_L()).a(new P()).a(new XKH_R()).a(new A()));
        //K→J<else>A
        G.add(new K().a(new J()).a(new ELSE()).a(new A()));
        //P→VQV
        G.add(new P().a(new V()).a(new Q()).a(new V()));
        //Q→>
        G.add(new Q().a(new GREATER_EQUAL()));
        //Q→<
        G.add(new Q().a(new LESS_EQUAL()));
        //Q→>=
        G.add(new Q().a(new GREATER()));
        //Q→<=
        G.add(new Q().a(new LESS()));
        //Q→==
        G.add(new Q().a(new EQUAL()));
        //Q→!=
        G.add(new Q().a(new NOTEQUAL()));
        //W→<while>(P)A
        G.add(new W().a(new WHILE()).a(new XKH_L()).a(new P()).a(new XKH_R()).a(new A()));
        //R→<return>V<;>
        G.add(new R().a(new RETURN()).a(new V()).a(new SEMICOLON()));
        //动态生成文法符号集
        for (NTChar i : G) {
            X.add(i);
            X.addAll(i.getProdRight());
        }
    }
}

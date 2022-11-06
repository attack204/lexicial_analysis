import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedHashSet;

//文法
public class Grammar {
    //产生式
    @Getter
    private static final ArrayList<NotEndToken> G = new ArrayList<>();

    //文法符号集
    @Getter
    private static final LinkedHashSet<AbstractToken> X = new LinkedHashSet<>();

    static {
        //S→O
        G.add(new NotEndToken(WD.S).a(new NotEndToken(WD.O)));
        //O→F
        G.add(new NotEndToken(WD.O).a(new NotEndToken(WD.F)));
        //O→OF
        G.add(new NotEndToken(WD.O).a(new NotEndToken(WD.O)).a(new NotEndToken(WD.F)));
        //F→TNXA
        G.add(new NotEndToken(WD.F).a(new NotEndToken(WD.T)).a(new NotEndToken(WD.N)).a(new NotEndToken(WD.X)).a(new NotEndToken(WD.A)));
        //T→<float>
        G.add(new NotEndToken(WD.T).a(new Token(WD.FLOAT)));
        //T→<int>
        G.add(new NotEndToken(WD.T).a(new Token(WD.INT)));
        //T→<string>
        G.add(new NotEndToken(WD.T).a(new Token(WD.STRING)));
        //T→<bool>
        G.add(new NotEndToken(WD.T).a(new Token(WD.BOOL)));
        //N→<main>
        G.add(new NotEndToken(WD.N).a(new Token(WD.MAIN)));
        //N→<ID>
        G.add(new NotEndToken(WD.N).a(new Token(WD.ID)));
        //X→()
        G.add(new NotEndToken(WD.X).a(new Token(WD.XKH_L)).a(new Token(WD.XKH_R)));
        //X→(T<ID>)
        G.add(new NotEndToken(WD.X).a(new Token(WD.XKH_L)).a(new NotEndToken(WD.T)).a(new Token(WD.ID)).a(new Token(WD.XKH_R)));
        //A→{}
        G.add(new NotEndToken(WD.A).a(new Token(WD.DKH_L)).a(new Token(WD.DKH_R)));
        //A→{L}
        G.add(new NotEndToken(WD.A).a(new Token(WD.DKH_L)).a(new NotEndToken(WD.L)).a(new Token(WD.DKH_R)));
        //L→Y
        G.add(new NotEndToken(WD.L).a(new NotEndToken(WD.Y)));
        //L→LY
        G.add(new NotEndToken(WD.L).a(new NotEndToken(WD.L)).a(new NotEndToken(WD.Y)));
        //Y→D
        G.add(new NotEndToken(WD.Y).a(new NotEndToken(WD.D)));
        //Y→Z
        G.add(new NotEndToken(WD.Y).a(new NotEndToken(WD.Z)));
        //Y→I
        G.add(new NotEndToken(WD.Y).a(new NotEndToken(WD.I)));
        //Y→W
        G.add(new NotEndToken(WD.Y).a(new NotEndToken(WD.W)));
        //Y→R
        G.add(new NotEndToken(WD.Y).a(new NotEndToken(WD.R)));
        //D→T<ID><;>
        G.add(new NotEndToken(WD.D).a(new NotEndToken(WD.T)).a(new Token(WD.ID)).a(new Token(WD.SEMICOLON)));
        //Z→B
        G.add(new NotEndToken(WD.Z).a(new NotEndToken(WD.B)));
        //Z→TB
        G.add(new NotEndToken(WD.Z).a(new NotEndToken(WD.T)).a(new NotEndToken(WD.B)));
        //B→<ID>=E<;>
        G.add(new NotEndToken(WD.B).a(new Token(WD.ID)).a(new Token(WD.ASSIGN)).a(new NotEndToken(WD.E)).a(new Token(WD.SEMICOLON)));
        //E→(E)
        G.add(new NotEndToken(WD.E).a(new Token(WD.XKH_L)).a(new NotEndToken(WD.E)).a(new Token(WD.XKH_R)));
        //E→V
        G.add(new NotEndToken(WD.E).a(new NotEndToken(WD.V)));
        //E→EGE
        G.add(new NotEndToken(WD.E).a(new NotEndToken(WD.E)).a(new NotEndToken(WD.G)).a(new NotEndToken(WD.E)));
        //V→<ID>
        G.add(new NotEndToken(WD.V).a(new Token(WD.ID)));
        //V→C
        G.add(new NotEndToken(WD.V).a(new NotEndToken(WD.C)));
        //C→<float_value>
        G.add(new NotEndToken(WD.C).a(new Token(WD.FLOAT_VALUE)));
        //C→<int_value>
        G.add(new NotEndToken(WD.C).a(new Token(WD.INT_VALUE)));
        //C→<string_value>
        G.add(new NotEndToken(WD.C).a(new Token(WD.STRING_VALUE)));
        //C→<bool_value>
        G.add(new NotEndToken(WD.C).a(new Token(WD.BOOL_VALUE)));
        //G→+
        G.add(new NotEndToken(WD.G).a(new Token(WD.ADD)));
        //G→-
        G.add(new NotEndToken(WD.G).a(new Token(WD.SUBTRACT)));
        //G→*
        G.add(new NotEndToken(WD.G).a(new Token(WD.MULTIPLY)));
        //G→/
        G.add(new NotEndToken(WD.G).a(new Token(WD.DIVIDE)));
        //I→J
        G.add(new NotEndToken(WD.I).a(new NotEndToken(WD.J)));
        //I→K
        G.add(new NotEndToken(WD.I).a(new NotEndToken(WD.K)));
        //J→<if>(P)A
        G.add(new NotEndToken(WD.J).a(new Token(WD.IF)).a(new Token(WD.XKH_L)).a(new NotEndToken(WD.P)).a(new Token(WD.XKH_R)).a(new NotEndToken(WD.A)));
        //K→J<else>A
        G.add(new NotEndToken(WD.K).a(new NotEndToken(WD.J)).a(new Token(WD.ELSE)).a(new NotEndToken(WD.A)));
        //P→VQV
        G.add(new NotEndToken(WD.P).a(new NotEndToken(WD.V)).a(new NotEndToken(WD.Q)).a(new NotEndToken(WD.V)));
        //Q→>
        G.add(new NotEndToken(WD.Q).a(new Token(WD.GREATER_EQUAL)));
        //Q→<
        G.add(new NotEndToken(WD.Q).a(new Token(WD.LESS_EQUAL)));
        //Q→>=
        G.add(new NotEndToken(WD.Q).a(new Token(WD.GREATER)));
        //Q→<=
        G.add(new NotEndToken(WD.Q).a(new Token(WD.LESS)));
        //Q→==
        G.add(new NotEndToken(WD.Q).a(new Token(WD.EQUAL)));
        //Q→!=
        G.add(new NotEndToken(WD.Q).a(new Token(WD.NOTEQUAL)));
        //W→<while>(P)A
        G.add(new NotEndToken(WD.W).a(new Token(WD.WHILE)).a(new Token(WD.XKH_L)).a(new NotEndToken(WD.P)).a(new Token(WD.XKH_R)).a(new NotEndToken(WD.A)));
        //R→<return>V<;>
        G.add(new NotEndToken(WD.R).a(new Token(WD.RETURN)).a(new NotEndToken(WD.V)).a(new Token(WD.SEMICOLON)));
        //动态生成文法符号集
        for (NotEndToken i : G) {
            X.add(i);
            X.addAll(i.getProdRight());
        }
    }
}

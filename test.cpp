#include<cstdio>
#include<memory>
#include<string>
#include<iostream>
#include<cstring>
using namespace std;
int main() {
    freopen("a.in", "r", stdin);
    freopen("a.out", "w", stdout);
    char s[1001];
    while(scanf("%s", s) != EOF) {
        int n = strlen(s);
        string ss;
        for(int i = 0; i < n; i++) {
            if(s[i] != ',') {
                ss += s[i];
            } else break;
        }
        if(!ss.empty()) {
            printf("else if(wd_ == WD.%s) {\n", ss.c_str());
            printf("    type = Types.%s;\n", ss.c_str());
            printf("}\n");
        }
    }

}
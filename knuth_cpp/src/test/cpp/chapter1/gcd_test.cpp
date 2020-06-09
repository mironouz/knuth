#include <cassert>
#include "../../../main/cpp/chapter1/gcd.cpp"

void TestGcd() {
    assert(gcd(7, 5) == 1);
    assert(gcd(18, 6) == 6);
    assert(gcd(2166, 6099) == 57);
}

int main(int argc, char** argv) {
    TestGcd();
    return 0;
}
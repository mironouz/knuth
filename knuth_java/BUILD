java_library(
    name = "knuth_java_src",
    srcs = glob(["src/main/java/com/chapter1/Gcd.java"]),
)

package(
    default_visibility = ["//src/test:__subpackages__"],
)

load("//:junit5.bzl", "java_junit5_test")

# Use java_test after bazel officially support junit5
java_junit5_test(
    name = "knuth_java",
    srcs = glob(["src/test/java/com/chapter1/GcdTest.java"]),
    test_package = "com.chapter1",
    deps = [
        ":knuth_java_src"
    ],
)
# AndroidUtil
Repository for having the mostly used utility code needed at almost every android application

How To Use
==========
Check documentation of `IntentUtil` [here](https://github.com/kawnayeen/AndroidUtil/tree/master/intentutil). <br/>
Check documentation for `Compressor` [here](https://github.com/zetbaitsu/Compressor#lets-compress-the-image-size).

Download
========
Grab via `gradle`:

In your project's `build.gradle` file, add the following repostiory under `allprojects`

```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

Now in your app's `build.gradle` file, add the following dependency
```
  compile 'com.github.kawnayeen:AndroidUtil:0.1.1'
```

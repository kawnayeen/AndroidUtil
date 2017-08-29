# AndroidUtil
Repository for having the mostly used utility code needed at almost every android application

How To Use
==========
- Check documentation of image picker intent utility [here](https://github.com/kawnayeen/AndroidUtil/tree/master/intentutil). <br/>
- Check documentation for image compressor [here](https://github.com/zetbaitsu/Compressor#lets-compress-the-image-size).

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

Or you can add individual module, if needed.
- For image compressor `com.github.kawnayeen.AndroidUtil:compressor:0.1.1`
- For image picker `com.github.kawnayeen.AndroidUtil:intentutil:0.1.1`

Below is the method count for each dependency

Gradle dependency | Method count  
--- | --- 
`com.github.kawnayeen:AndroidUtil:0.1.1` | 119
`com.github.kawnayeen.AndroidUtil:compressor:0.1.1` |  39
`com.github.kawnayeen.AndroidUtil:intentutil:0.1.1` | 80

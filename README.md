![](/media/git-header.png)

[![](https://jitpack.io/v/alibardide5124/ComposeAdvancedShadow.svg)]

# Compose Advanced Shadow

`ComposeAdvancedShadow` is a powerful Android Compose library that enables developers to easily create 
and customize stunning, high-quality shadows for their UI elements.

![](/media/demo.gif)

Features
- Create custom shadows with `offset`, `color`, `spread` and `blur` support using Android Compose.
- Shadows implemented using View.LAYER_TYPE_SOFTWARE to render correctly in android api < 28
- Highly customizable

To view sample app just download apk from releases, or clone this repository to discover

## Setup
Add it in your root build.gradle at the end of repositories:

``` groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

Then add the dependency
``` groovy
dependencies {
    implementation 'com.github.alibardide5124:ComposeAdvancedShadow:{latest-version}'
}
```
latest version: [![](https://jitpack.io/v/alibardide5124/ComposeAdvancedShadow.svg)]

## Guide

`ComposeAdvancedShadow` gives you a custom `Modifier` named `advancedShadow`. It has following params:

| Param          | Description                                                         |
|----------------|---------------------------------------------------------------------|
| `color`        | Color of the shadow                                                 |
| `borderRadius` | Border radius for rounded layout                                    |
| `blurRadius`   | Amount of shadow blur                                               |
| `offsetY`      | Set offsetY of shadow                                               |
| `offsetX`      | Set offsetX of shadow                                               |
| `spread`       | Amount of shadow spread                                             |
| `alpha`        | Shadow Color Alpha. Its recommended to use alpha for better shadows |

## Support

If you like this application, just support it by joining [**stargazers**](https://https://github.com/alibardide5124/News-app/stargazers) for this repository
<br/>
And [**follow me**](https://https://https://github.com/alibardide5124?tab=followers) for my next creations

## License

ComposeAdvancedShadow by [Ali Bardide](https://github.com/alibardide5124) is licensed under a [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0).

## Credits

Special thanks to the [GoDaddy](https://github.com/godaddy) for [color picker library](https://github.com/godaddy/compose-color-picker).

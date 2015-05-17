# shining-textview
Textview that will shine with colors :)

This will help users to build text view with sleek color animation.


Apache 2.0

`<stv.squidproxy.com.lib.ShiningTextView
        android:text="@string/hello_world"     
        android:layout_width="match_parent"    
        android:layout_height="wrap_content"    
        app:speed="1"    
        app:color_array="@array/rainbow_colors"    
        android:textSize="32sp" />    `
 

add this view to your layout

text size,speed and color array can be customized.

`<?xml version="1.0" encoding="utf-8"?>
<resources>
    <array name="rainbow_colors" >
        <item>@color/violet</item>
        <item>@color/indigo</item>
        <item>@color/blue</item>
        <item>@color/green</item>
        <item>@color/yellow</item>
        <item>@color/orange</item>
        <item>@color/red</item>
    </array>
</resources>`

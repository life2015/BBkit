package com.twtstudio.retrox.myapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Spannable
import android.text.method.LinkMovementMethod
import android.util.Log
import android.view.MotionEvent
import android.widget.TextView
import com.twtstudio.retrox.bbcode.NaiveHtmlUtils
import org.kefirsf.bb.BBProcessorFactory
import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter
import org.sufficientlysecure.htmltextview.HtmlTextView

/**
 * Created by retrox on 19/05/2017.
 */

class BBActivity : AppCompatActivity(){

    val bbTextView by lazy { findViewById(R.id.text_html) as HtmlTextView }
    val textProcessor = BBProcessorFactory.getInstance().create()
//    val bbstr = "[align=center][color=rgb(209,72,65)][b]利[/b][/color][/align]"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bb)

        val htmlText = "[B]text[/B] [i]text[/i]  [u]text[/u]  [s]text[/s]  [color=#FF0000]Red[/color]  " +
                "[url=http://example.com]Example[/url]\n" +
                "[url]http://example.org[/url]\n" +
                "[img]https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/Laser_Towards_Milky_Ways_Centre.jpg/660px-Laser_Towards_Milky_Ways_Centre.jpg[/img]\n" +
                "[quote=auther]quoted text[/quote]" +
                "[img]http://attach.bbs.miui.com/forum/201402/21/120043wsfuzzuefyasz3fe.jpg[/img]\n" +
                "[img]https://upload.wikimedia.org/wikipedia/commons/thumb/c/c0/Gnome-emblem-web.svg/50px-Gnome-emblem-web.svg.png[/img]\n" +
                "[list] [*]Entry 1 [*]Entry 2 [/list]0000" +
                "[size=15] Entry 2 size test [/size] \n" +
                "[list] [*]Entry 3 [*]Entry 4 [/list]" +
                "[list] *Entry 5 *Entry 6 [/list]" +
                "[ol][li]Item 11[/il][li]Item 12[/il][/ol]" +
                "[ul][li]Item 21[/il][li]Item 22[/il][/ul]" +
                "[list][li]Item 31[/il][li]Item 32[/il][/list]" +
                "[code]String TAG = \"tag\"[/code]" +
                "[center]This is some centered text[/center]" +
                ""

        // bbcode转html
        val bbHtml = com.twtstudio.retrox.bbcode.BBCodeParse.bbcode2Html(htmlText)

        Log.d("tag",bbHtml)
        // 测试获取图片的方法
        NaiveHtmlUtils.GetHtmlImageSrcList(bbHtml).forEach {
            Log.d("img",it)
        }

        // ImageGetter是必须的，HttpImageGetter是用来获取网络图片的
        // 如果后台骚搞图片的URL，继承重写getDrawable方法
        bbTextView.setHtml(bbHtml,HtmlHttpImageGetter(bbTextView))

    }
}

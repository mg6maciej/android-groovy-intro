package pl.mg6.grooid.intro

import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import groovy.transform.CompileStatic

@CompileStatic
final class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        contentView = R.layout.main_activity
        'dsadsa'
        //setContentView(R.layout.new_activity)
        def text = (TextView) findViewById(R.id.text)
        text.onClickListener = this.&onTextClick
        int x = 5
        String str = 'My value is: ' + x.intValue()
    }

    void onTextClick(View view) {

    }
}

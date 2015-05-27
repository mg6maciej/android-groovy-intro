package pl.mg6.grooid.intro

import android.os.Bundle
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import groovy.transform.CompileStatic
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1;

@CompileStatic
public final class MainActivity extends AppCompatActivity {

    UserService service = new UserService()

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        def edit = findViewById(R.id.edit) as EditText
        edit.addTextChangedListener(createTextWatcher())
    }

    private TextWatcher createTextWatcher() {
        return new TextWatcher() {

            @Override
            void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            void afterTextChanged(Editable s) {
                textChanged(s.toString().trim())
            }
        }
    }

    void textChanged(String name) {
        service.call(name)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this.&showUser, {})
    }

    private void showUser(User user) {
        def textView = findViewById(R.id.text) as TextView
        textView.text = "${user.name} ${user.company}"
    }
}

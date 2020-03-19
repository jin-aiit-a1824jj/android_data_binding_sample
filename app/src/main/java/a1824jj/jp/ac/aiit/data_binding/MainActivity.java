package a1824jj.jp.ac.aiit.data_binding;

import a1824jj.jp.ac.aiit.data_binding.databinding.ActivityMainBinding;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //private TextView nameText;
    //private TextView emailText;

    private ActivityMainBinding activityMainBinding;
    private MainActivityClickHandlers handlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        nameText = findViewById(R.id.tvStudentName);
//        emailText = findViewById(R.id.tvStudentEmail);
//
//        nameText.setText(getCurrentStudent().getStudentName());
//        emailText.setText(getCurrentStudent().getStudentEmail());

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setStudent(getCurrentStudent());

        handlers = new MainActivityClickHandlers(this);
        activityMainBinding.setClickHandler(handlers);
    }

    private Student getCurrentStudent(){
        Student student = new Student();
        student.setStudentEmail("Alex");
        student.setStudentName("alex@gmail.com");
        return student;
    }

    public class MainActivityClickHandlers{
        Context context;

        public MainActivityClickHandlers(Context context){
            this.context = context;
        }

        public void onEnrollButtonClicked(View view){
            Toast.makeText(context, "Enroll Clicked!", Toast.LENGTH_LONG).show();
        }

        public void onCancelButtonClicked(View view){
            Toast.makeText(context, "Cancel Clicked!", Toast.LENGTH_LONG).show();
        }
    }
}

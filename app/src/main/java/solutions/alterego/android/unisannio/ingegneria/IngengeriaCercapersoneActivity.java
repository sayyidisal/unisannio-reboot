package solutions.alterego.android.unisannio.ingegneria;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import solutions.alterego.android.unisannio.R;
import solutions.alterego.android.unisannio.cercapersone.Person;

public class IngengeriaCercapersoneActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingengeria_cercapersone);

        TextView tv = (TextView) findViewById(R.id.tvCercapersoneIngegneria);
        SearchView sv = (SearchView) findViewById(R.id.searchViewCercapersoneIngegneria);

        IngegneriaCercapersonePresenter icp = new IngegneriaCercapersonePresenter();

        icp.getPeople()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArrayList<Person>>() {
                    @Override
                    public void onCompleted() {
                        //Log.e("ACTIVITY CERCAPERSONE onCompleted()","Completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("ACTIVITY CERCAPERSONE onError()",e.toString());
                    }

                    @Override
                    public void onNext(ArrayList<Person> persons) {

                        for(Person p: persons){
                            //Log.e("ACTIVITY CERCAPERSONE onNext()",p.getNome());
                            tv.setText(p.getNome());
                        }


                    }
                });



    }
}

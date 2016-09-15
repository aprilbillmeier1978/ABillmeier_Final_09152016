package mobile.rasmussen.edu.afinal;


import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserProfile extends Activity {

    Button savebtn,okbtn,addbtn,viewbtn;
    EditText nameadd,locationadd,occupationadd,ageadd,experienceadd;
    TextView nametxt,locationtxt, occupationtxt, agetxt, experiencetxt;
    Dialog AddDialog,ViewDialog;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        pref = getSharedPreferences("ProfilePref", MODE_PRIVATE);
        addbtn = (Button)findViewById(R.id.add);
        viewbtn = (Button)findViewById(R.id.view);

        addbtn.setOnClickListener(new View.OnClickListener() {
            String name,location,occupation,age,experience;

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                //Dialog to Get User Input
                AddDialog = new Dialog(UserProfile.this);
                AddDialog.setContentView(R.layout.profile_fragment);
                AddDialog.setTitle("Enter Your Profile");
                nameadd = (EditText)AddDialog.findViewById(R.id.name);
                locationadd = (EditText)AddDialog.findViewById(R.id.location);
                occupationadd = (EditText)AddDialog.findViewById(R.id.occupation);
                ageadd = (EditText)AddDialog.findViewById(R.id.age);
                experienceadd = (EditText)AddDialog.findViewById(R.id.experience);

                savebtn = (Button)AddDialog.findViewById(R.id.saveBtn);
                savebtn.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View arg0) {
                        // TODO Auto-generated method stub
                        name = nameadd.getText().toString();
                        location = locationadd.getText().toString();
                        occupation = occupationadd.getText().toString();
                        age = ageadd.getText().toString();
                        experience = experienceadd.getText().toString();

                        SharedPreferences.Editor edit = pref.edit();
                        //Storing Data using SharedPreferences
                        edit.putString("Name", name);
                        edit.putString("Location", location);
                        edit.putString("Occupation", occupation);
                        edit.putString("Age", age);
                        edit.putString("Experience", experience);
                        edit.commit();
                        AddDialog.dismiss();
                    }
                });

                AddDialog.show();
            }
        });

        viewbtn.setOnClickListener(new View.OnClickListener() {
            String getname,getlocation,getoccupation,getage,getexperience;

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                //Dialog to display output
                ViewDialog = new Dialog(UserProfile.this);
                ViewDialog.setContentView(R.layout.view_profile_fragment);
                ViewDialog.setTitle("Profile Details");
                nametxt = (TextView)ViewDialog.findViewById(R.id.name);
                locationtxt = (TextView)ViewDialog.findViewById(R.id.location);
                occupationtxt = (TextView)ViewDialog.findViewById(R.id.occupation);
                agetxt = (TextView)ViewDialog.findViewById(R.id.age);
                experiencetxt = (TextView)ViewDialog.findViewById(R.id.experience);
                okbtn = (Button)ViewDialog.findViewById(R.id.okBtn);

                //Getting Stored data from SharedPreferences
                getname = pref.getString("Name", "");
                getlocation = pref.getString("Location", "");
                getoccupation = pref.getString("Occupation", "");
                getage = pref.getString("Age", "");
                getexperience = pref.getString("Experience", "");

                nametxt.setText("Name is:" +getname);
                locationtxt.setText("Location is:" +getlocation);
                occupationtxt.setText("Occupation is:" +getoccupation);
                agetxt.setText("Age is:" +getage);
                experiencetxt.setText("Experience is:" +getexperience);
                okbtn.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View arg0) {
                        // TODO Auto-generated method stub
                        ViewDialog.dismiss();
                    }
                });
                ViewDialog.show();
            }
        });
    }

}


package com.example.loan.customer;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText mEditTextName;
    RadioButton mRadioNoteBook;
    RadioButton mRadioBook;
    RadioButton mRadioPen;
    RadioGroup mRadioGroup;
    EditText mNumber;
    Button mButtonSave;
    Button mButtonCancal;
    ListView listView;
    ListViewAdapter listViewAdapter;
    String noteBook;
    String status;
    String book;
    String pen;
    public final  List<Customer> customerList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get id
        mEditTextName=(EditText) findViewById(R.id.editTextName);
        mRadioNoteBook=(RadioButton) findViewById(R.id.radioNoteBook);
        mRadioBook=(RadioButton) findViewById(R.id.radioBook);
        mRadioPen=(RadioButton) findViewById(R.id.radioPen);
        mRadioGroup=(RadioGroup) findViewById(R.id.radioParent);
        mNumber=(EditText) findViewById(R.id.editTextNum);
        mButtonSave=(Button) findViewById(R.id.buttonSave);
        mButtonCancal=(Button) findViewById(R.id.buttonCancal);

        listView=(ListView)findViewById(R.id.listView);
        //dang ki menucontext cho Edittext Name
        registerForContextMenu(mEditTextName);
        //cancal click;
        mButtonCancal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditTextName.setText("");
                mEditTextName.requestFocus();

            }
        });
        //check editText changed
        //radio check
        this.mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int Id=group.getCheckedRadioButtonId();
                if(Id==R.id.radioBook)
                {
                    status="book";
                    mNumber.setText(book);
                }
                else if(Id==R.id.radioNoteBook)
                {
                    status="noteBook";
                    mNumber.setText(noteBook);
                }
                else
                {
                    status="pen";
                    mNumber.setText(pen);
                }
            }
        });
        //edittext so luong  changed
        mNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(status=="book")
                    book=mNumber.getText().toString();
                 if(status=="noteBook")
                    noteBook=mNumber.getText().toString();
                if(status=="pen")
                    pen=mNumber.getText().toString();
            }
        });
        mEditTextName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mNumber.setText("");
                book="";
                noteBook="";
                pen="";
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //save click

        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name=mEditTextName.getText().toString();

                if(!name.equals(""))
                {
                    if(noteBook.equals(""))
                    {
                        noteBook="0";
                    }
                    if(book.equals(""))
                    {
                        book="0";
                    }
                    if(pen.equals(""))
                    {
                        pen="0";
                    }
                    Customer customer=new Customer();
                    customer.setName(name);
                    customer.setNoteBook(noteBook);
                    customer.setBook(book);
                    customer.setPen(pen);
                    customerList.add(customer);

                    listViewAdapter=new ListViewAdapter(getBaseContext(),customerList);
                    listView.setAdapter(listViewAdapter);
                    listViewAdapter.notifyDataSetChanged();
                    Toast.makeText(getBaseContext(),"Đã lưu khách hàng "+name,Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getBaseContext(),"Vui lòng nhập tên khách hàng",Toast.LENGTH_LONG).show();

            }
        });
        //show menucontext


    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menucontext,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.mDelete:
                new AlertDialog.Builder(this)
                .setTitle("Thông báo")
                        .setMessage("Bạn có muốn xóa")
                        .setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mEditTextName.setText("");
                            }
                        })
                        .setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

        }
        return super.onContextItemSelected(item);
    }
}

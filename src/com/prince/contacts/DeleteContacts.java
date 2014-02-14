package com.prince.contacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteContacts extends Activity implements OnClickListener {

	private EditText edtDeleteContactNumber;
	private Button btnDeleteContact, btnDeleteCancel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.deletecontact);

		edtDeleteContactNumber = (EditText) findViewById(R.id.edtDeleteContactNumber);

		btnDeleteContact = (Button) findViewById(R.id.btndeleteContact);
		btnDeleteCancel = (Button) findViewById(R.id.btnDeleteCancel);

		btnDeleteContact.setOnClickListener(this);
		btnDeleteCancel.setOnClickListener(this);

	}

	public void onClick(View v) {
		Intent intent = new Intent(this, MainActivity.class);
		if (v.getId() == R.id.btndeleteContact) {
			if (edtDeleteContactNumber.getText().toString().equals("")) {
				Toast.makeText(this, "Please fill both fields...",
						Toast.LENGTH_SHORT).show();
			} else {
				ContactHelper.deleteContact(getContentResolver(),
						edtDeleteContactNumber.getText().toString());
				edtDeleteContactNumber.setText("");

				startActivity(intent);
			}

		} else if (v.getId() == R.id.btnDeleteCancel) {
			startActivity(intent);
		}

	}
}

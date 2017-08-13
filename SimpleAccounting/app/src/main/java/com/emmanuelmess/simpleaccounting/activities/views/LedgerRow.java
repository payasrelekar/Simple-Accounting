package com.emmanuelmess.simpleaccounting.activities.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;

import com.emmanuelmess.simpleaccounting.R;

import java.math.BigDecimal;

/**
 * @author Emmanuel
 *         on 7/8/2017, at 23:54.
 */

public class LedgerRow extends TableRow {

	private TextView dateText, referenceText, creditText, debitText, balanceText;
	private EditText dateEditText, referenceEditText, creditEditText, debitEditText;
	private BalanceFormatter formatter;

	public LedgerRow(Context context) {
		super(context);
		createInstance();
	}

	public LedgerRow(Context context, AttributeSet attrs) {
		super(context, attrs);
		createInstance();
	}

	private void createInstance() {
		dateText = ((TextView) findViewById(R.id.textDate));
		referenceText = ((TextView) findViewById(R.id.textRef));
		creditText = ((TextView) findViewById(R.id.textCredit));
		debitText = ((TextView) findViewById(R.id.textDebit));
		balanceText = (TextView) findViewById(R.id.textBalance);

		dateEditText = ((EditText) findViewById(R.id.editDate));
		referenceEditText = ((EditText) findViewById(R.id.editRef));
		creditEditText = ((EditText) findViewById(R.id.editCredit));
		debitEditText = ((EditText) findViewById(R.id.editDebit));
	}

	public void setDate(String date) {
		dateText.setText(date);
	}

	public void setReference(String ref) {
		referenceText.setText(ref);
	}

	public void setCredit(BigDecimal credit) {
		creditText.setText(credit.toPlainString());
	}

	public void setDebit(BigDecimal debit) {
		debitText.setText(debit.toPlainString());
	}

	public void setBalance(BigDecimal balance) {
		balanceText.setText(formatter.format(balance));
	}

	public void invertDebitCredit() {
		findViewById(R.id.textCredit).setId(0);
		findViewById(R.id.textDebit).setId(R.id.textCredit);
		findViewById(0).setId(R.id.textDebit);

		findViewById(R.id.editCredit).setId(0);
		findViewById(R.id.editDebit).setId(R.id.editCredit);
		findViewById(0).setId(R.id.editDebit);

		((EditText) findViewById(R.id.editCredit)).setHint(R.string.credit);
		((EditText) findViewById(R.id.editDebit)).setHint(R.string.debit);

		creditText = ((TextView) findViewById(R.id.textCredit));
		debitText = ((TextView) findViewById(R.id.textDebit));
		creditEditText = ((EditText) findViewById(R.id.editCredit));
		debitEditText = ((EditText) findViewById(R.id.editDebit));
	}

	public static interface BalanceFormatter {
		String format(BigDecimal balance);
	}

}

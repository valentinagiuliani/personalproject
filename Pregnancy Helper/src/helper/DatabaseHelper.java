package helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper{
	//Logcat tag
	private static final String LOG="DatabaseHelper";
	//Database Version
	private static final int DATABASE_VERSION =1;
	//Database name
	private static final String DATABASE_NAME="Database";
	//tables name
	private static final String TABLE_ULTIMA="Ultima";
	
	private static final String KEY_DATA="data"; //data ultima mestruazione
	
	private static final String CREATE_TABLE_ULTIMA="CREATE TABLE " + TABLE_ULTIMA+ "(" + KEY_DATA +" DATE PRIMARY KEY" + ")";
	
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME,null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_TABLE_ULTIMA);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS "+ TABLE_ULTIMA);
		onCreate(db);
	}
	
	public void insert(String date) {
	    SQLiteDatabase db = this.getWritableDatabase();
	 
	    ContentValues values = new ContentValues();
	    values.put(KEY_DATA,date);
	    
	    // insert row
	    db.insert(TABLE_ULTIMA, null, values);
	 
	}
	
	public String getDate(){
		String selectQuery ="SELECT * FROM " + TABLE_ULTIMA;
		Log.e(LOG,selectQuery);
		
		SQLiteDatabase db= this.getReadableDatabase();
		Cursor c =db.rawQuery(selectQuery, null);
		String result = null;
		if(c.moveToFirst()){   
			result = c.getString(c.getColumnIndex(KEY_DATA));
		}
	    return result;
	}
/*	
	public int updateGioc() {
	    SQLiteDatabase db = this.getWritableDatabase();
	 
	    ContentValues values = new ContentValues();
	    values.put(KEY_NOME, g.getNome());
	    values.put(KEY_COGNOME, g.getCognome());
	    values.put(KEY_RUOLO, g.getRuolo());
	    values.put(KEY_NUMERO, g.getNumero());
	 
	    // updating row
	    return db.update(TABLE_GIOCATORI, values, KEY_NOME + " = ?",
	            new String[] { String.valueOf(g.getNumero()) });
	}
	
	public void deleteGioc(Giocatore g) {
	    SQLiteDatabase db = this.getWritableDatabase();
	    db.delete(TABLE_GIOCATORI, KEY_NUMERO + " = ?",
	            new String[] { String.valueOf(g.getNumero()) });
	}
	
	public void deletBot(String numerobottone){
		SQLiteDatabase db =this.getWritableDatabase();
		db.delete(TABLE_BOTTONI, KEY_NUMEROBOTTONE + " = ?", new String[] { numerobottone});
		
	}
	*/
	public void delete() {
	    SQLiteDatabase db = this.getWritableDatabase();
	   // String query="DELETE *";
	    db.delete(TABLE_ULTIMA,null, null);
	}
	
	
	public void closeDB() {
	    SQLiteDatabase db = this.getReadableDatabase();
	    
	    if (db != null && db.isOpen())
	            db.close();
	    }
}


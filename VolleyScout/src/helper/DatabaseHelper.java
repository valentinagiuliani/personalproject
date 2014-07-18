package helper;

import java.util.ArrayList;
import java.util.List;

import model.BottoneMaglia;
import model.Giocatore;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
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
	private static final String TABLE_GIOCATORI="Giocatori";
	private static final String TABLE_BOTTONI="Bottoni";
	//nome colonne tabella
	private static final String KEY_NOME="nome";
	private static final String KEY_COGNOME="cognome";
	private static final String KEY_RUOLO="ruolo";
	private static final String KEY_NUMERO="numero"; // numeromaglia
	
	private static final String KEY_NUMEROBOTTONE="numerobottone"; //numerobottone
	
	private static final String CREATE_TABLE_GIOCATORI="CREATE TABLE " + TABLE_GIOCATORI+ "(" + KEY_NUMERO +" TEXT PRIMARY KEY," + KEY_NOME + " TEXT," + KEY_COGNOME +" TEXT," + KEY_RUOLO + " TEXT" + ")";
	private static final String CREATE_TABLE_BOTTONI="CREATE TABLE " + TABLE_BOTTONI+ "(" + KEY_NUMEROBOTTONE +" TEXT PRIMARY KEY," + KEY_NUMERO + " TEXT" + ")";

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME,null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_TABLE_GIOCATORI);
		db.execSQL(CREATE_TABLE_BOTTONI);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS "+ TABLE_GIOCATORI);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOTTONI);
		onCreate(db);
	}
	
	public void insertGioc(Giocatore g) {
	    SQLiteDatabase db = this.getWritableDatabase();
	 
	    ContentValues values = new ContentValues();
	    values.put(KEY_NOME, g.getNome());
	    values.put(KEY_COGNOME, g.getCognome());
	    values.put(KEY_RUOLO, g.getRuolo());
	    values.put(KEY_NUMERO, g.getNumero());
	 
	    // insert row
	    db.insert(TABLE_GIOCATORI, null, values);
	 
	}
	
	public void insertGiocBot(Giocatore g,String b) {
	    SQLiteDatabase db = this.getWritableDatabase();
	 
	    ContentValues values = new ContentValues();
	    values.put(KEY_NUMEROBOTTONE, b);
	    values.put(KEY_NUMERO, g.getNumero());
	 
	    // insert row
	    db.insert(TABLE_BOTTONI, null, values);
	 
	}
	
	public Giocatore getGiocatore(String numero){
		SQLiteDatabase db=this.getReadableDatabase();
		String selectQuery = "SELECT * FROM " + TABLE_GIOCATORI + " WHERE " + KEY_NUMERO +"=" + numero;
		Log.e(LOG, selectQuery);
		Cursor c = db.rawQuery(selectQuery, null);
		
		if(c!=null && c.moveToFirst())
			c.moveToFirst();
		
		Giocatore gioc = new Giocatore();
		gioc.setNome(c.getString(c.getColumnIndex(KEY_NOME)));
		gioc.setCognome(c.getString(c.getColumnIndex(KEY_COGNOME)));
		gioc.setRuolo(c.getString(c.getColumnIndex(KEY_RUOLO)));
		gioc.setNumero(c.getString(c.getColumnIndex(KEY_NUMERO)));
		return gioc;
	}
	
	public String getNumeroMaglia(String text){ // mi restituisce il numero della maglia e gli passo il numero del bottone
		String numero = "";
		try{
		SQLiteDatabase db=this.getReadableDatabase();
		String selectQuery = "SELECT * FROM " + TABLE_BOTTONI + " WHERE " +
		KEY_NUMEROBOTTONE +" = '" + text+"'" ;
		Log.e(LOG, selectQuery);
		Cursor c = db.rawQuery(selectQuery, null);
		if(c!=null && c.moveToFirst())
		{
		c.moveToFirst();
		numero=c.getString(c.getColumnIndex(KEY_NUMERO));
		Log.i("NUMERO_GIOCATORE", numero); // verifichi se è così che non ho la documentazione sotto mano e non sono sicuro che è Log.i(..) per visualizzare le informazioni, forse è Log.v(..)
		}
		c.close(); //si ricordi che il cursore va sempre chiuso
		if(numero.equals(""))
		numero="ERROR_NUM_NOT_FOUND";

		}catch(SQLException ex){
					Log.e(LOG, "getTestData >>"+ ex.toString()); 
					throw ex; 
				}

		return numero;
	}
	
	public String getNumeroBottone(String text){ // mi restituisce il numero del bottone e gli passo il numero della maglia
		String numero = "";
		try{
		SQLiteDatabase db=this.getReadableDatabase();
		String selectQuery = "SELECT * FROM " + TABLE_BOTTONI + " WHERE " +
		KEY_NUMERO +" = '" + text+"'" ;
		Log.e(LOG, selectQuery);
		Cursor c = db.rawQuery(selectQuery, null);
		if(c!=null && c.moveToFirst())
		{
		c.moveToFirst();
		numero=c.getString(c.getColumnIndex(KEY_NUMEROBOTTONE));
		Log.i("NUMERO_BOTTONE", numero); // verifichi se è così che non ho la documentazione sotto mano e non sono sicuro che è Log.i(..) per visualizzare le informazioni, forse è Log.v(..)
		}
		c.close(); //si ricordi che il cursore va sempre chiuso
		if(numero.equals(""))
		numero="ERROR_NUM_NOT_FOUND";

		}catch(SQLException ex){
					Log.e(LOG, "getTestData >>"+ ex.toString()); 
					throw ex; 
				}

		return numero;
		}
	
	public List<Giocatore> getAllGioc(){
		List<Giocatore> lista =new ArrayList<Giocatore>(); 
		String selectQuery ="SELECT * FROM " + TABLE_GIOCATORI;
		Log.e(LOG,selectQuery);
		
		SQLiteDatabase db= this.getReadableDatabase();
		Cursor c =db.rawQuery(selectQuery, null);
		
		if (c.moveToFirst()) {
	        do {
	            Giocatore gioc = new Giocatore();
	            gioc.setNome(c.getString(c.getColumnIndex(KEY_NOME)));
	    		gioc.setCognome(c.getString(c.getColumnIndex(KEY_COGNOME)));
	    		gioc.setRuolo(c.getString(c.getColumnIndex(KEY_RUOLO)));
	    		gioc.setNumero(c.getString(c.getColumnIndex(KEY_NUMERO)));
	 
	            // adding to todo list
	            lista.add(gioc);
	        } while (c.moveToNext());
	    }
	 
	    return lista;
	}
	
	public List<BottoneMaglia> getAllBott(){
		List<BottoneMaglia> lista =new ArrayList<BottoneMaglia>(); 
		String selectQuery ="SELECT * FROM " + TABLE_BOTTONI;
		Log.e(LOG,selectQuery);
		
		SQLiteDatabase db= this.getReadableDatabase();
		Cursor c =db.rawQuery(selectQuery, null);
		
		if (c.moveToFirst()) {
	        do {
	            BottoneMaglia b = new BottoneMaglia();
	    		b.setNumeroBottone(c.getString(c.getColumnIndex(KEY_NUMEROBOTTONE)));
	    		b.setNumeroMaglia(c.getString(c.getColumnIndex(KEY_NUMERO)));
	            // adding to todo list
	            lista.add(b);
	        } while (c.moveToNext());
	    }
	 
	    return lista;
	}
	public int updateGioc(Giocatore g) {
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
	
	public void delete() {
	    SQLiteDatabase db = this.getWritableDatabase();
	   // String query="DELETE *";
	    db.delete(TABLE_GIOCATORI,null, null);
	    db.delete(TABLE_BOTTONI,null, null);
	}
	
	
	public void closeDB() {
	    SQLiteDatabase db = this.getReadableDatabase();
	    
	    if (db != null && db.isOpen())
	            db.close();
	    }
}

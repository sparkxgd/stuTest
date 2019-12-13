package demo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoDBCn {
	
	private MongoCollection<Document> collection;
	
	public MongoDBCn(String host,String dbname,String table) {
		// ���ӵ� mongodb ����
		MongoClient mongoClient = new MongoClient(host, 27017);
		// ���ӵ����ݿ�
		MongoDatabase mongoDatabase = mongoClient.getDatabase(dbname);
		// ���ӵ�����
		this.collection = mongoDatabase.getCollection(table);
	}
	/**
	 *	  ���
	 */
	public void insert(Document data) {
		  collection.insertOne(data); 
	}
	/**
	 *	  ɾ��
	 */
	public void delete(Document query) {
		collection.deleteOne(query);
	}
	/**
	 *	  ����
	 */
	public List<Document> find(Document query){
		FindIterable<Document> findIterable = collection.find(query);  
        MongoCursor<Document> mongoCursor = findIterable.iterator();  
        List<Document> list=new ArrayList<Document>();
        while(mongoCursor.hasNext()){  
        	list.add(mongoCursor.next());  
        }  
        return list;
	}
	/**
	 *	  ����
	 */
	public void updata(Document data) {
        collection.updateMany(Filters.eq("no", data.get("no")), new Document("$set",data)); 
	}

}

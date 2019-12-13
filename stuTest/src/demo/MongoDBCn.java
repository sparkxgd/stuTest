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
		// 连接到 mongodb 服务
		MongoClient mongoClient = new MongoClient(host, 27017);
		// 连接到数据库
		MongoDatabase mongoDatabase = mongoClient.getDatabase(dbname);
		// 连接到集合
		this.collection = mongoDatabase.getCollection(table);
	}
	/**
	 *	  添加
	 */
	public void insert(Document data) {
		  collection.insertOne(data); 
	}
	/**
	 *	  删除
	 */
	public void delete(Document query) {
		collection.deleteOne(query);
	}
	/**
	 *	  查找
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
	 *	  更新
	 */
	public void updata(Document data) {
        collection.updateMany(Filters.eq("no", data.get("no")), new Document("$set",data)); 
	}

}

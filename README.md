Hibernate Notes:-
===============
									               
Framework:
----------
   Framework is solution to common problem which occurs is application development.

Problem Of Jdbc:-
-----------------
 (1)Object  to value conversin and vice versa.
 (2)Developer should have knowledge of sql.
 (3)Java class is directly dependent on database.
 (4)Developer has to mannually close the resources like Connection,Statement and ResultSet.

Hibernate(5.X):- Hibernate is an open source ORM Tool.

ORM(Object Relational Mapping):- Provides guidlines to Map java object directly to database 
      without converting the value.
	  
Tools Required to develop a hibernate application:
 1.Eclipse
 2.SQL YOG(UI for MySql) 
 
Steps to create Hibernate application:
--------------------------------------
  1.Create a Simple java project.
  2.Create a folder 'lib'.
  3.Copy all the jars and do the build path.
  4.create proper package under src.
  5.Create a xml file with the name "hibernate.cfg.xml" under the src.
  6.Create a DTO class inside a package.
  7.Create a Mapping file.
  8.Create a DAO class inside the package.

Rules to Create a DTO:-
------------------------
   1.Create a class which implements Serializable interface.
   2.Create private data members.
   3.Generate public getters and setters.
   4.Create a public constructor.
   5.The class should be non abstract.
       DTO is a design pattern which is use to transfer data between the layers.
	ex:
     @Entity
     @Table(name="music_table")
     public class MusicDTO implements Serializable{
	  @Id
	  @Column(name="music_name")
	  private String name;
	  @Column(name="music_artist")
	  private String artist;
	  @Column(name="music_length")
	  private int length;
	  @Column(name="yearOfRelease")
	  private int yearOfRelease;
	  //generate getters and setters.
	   public MusicDTO()
	   {
	   }
      }	  
	 
To obtain DTD:

 1.Extract a jar called as hibernate-core 5.0.4.
 2.Navigate to org.
 3.Open hibernate folder.
 4.Search for a file with name hibernate-configuration.
 5.copy line 10 to 12.
   like:
   /*
     <!DOCTYPE hibernate-configuration PUBLIC
	"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
	"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">*/
 6.Then paste into xml file. 
  
  xml file:
  <hibernate-configuration>
  <session-factory>
  <property name="connection.username">root</property>
  <property name="connection.password">root</property>
  <property name="connection.url">jdbc:mysql://localhost:3306/DatabaseName</property>
  <property name="connection.driver_class">com.mysql.jdbc.Driver</property>
  </session-factory>
  </hibernate-configuration>
  
  @Table(name="table_name"):It is use to provide information about the table.
  @Column(name="attribute_name"):It is use to map data members to a particular column in the table.
  @Id:-It is use to provide the information about the primary key.
  @Entity:-It is used to convert DTO to an entity so that hibernate can perfrom CRUD operation.
 
Steps to Create a DAO class:

  1.Create a class with a main method .
  2.Create an object of DTO and populate the values.
  3.Use a component called as configuration.
  4.Load the resources (hibernate.cfg.xml and Mapping class) using factory SessionFactory.
  5.Obtain a session using session factory.
  6.Using Session perfrom crud operation.
  
There are Three Component in hibernate :-
   1.Configuration(C)
   2.SessionFactory(I)
   3.Session(I) 

  (1)Configuration:-
  -------------------
        >It is a class which is present in 'org.hibernate.cfg' package.
        >It is use for two purpose:
          (1)It is use to load the resources.
          (2)It is use obtain the SessionFactory object.
          (3)To load configuration file we need to use a method called as configure().
             > Once configure is used it always searches for a file with name 'hibernate.cfg.xml'
                under the src folder.
         	 > If it doesn't find the configuration file then it throws an exception.
        >To load mapping class we have to use 'addAnnotedClass(DTOClass.class)'.
        >To obtain SessionFactory object we have to use a helper method called as 'buildSessionFactory()'.
        >The Return type buildSessionFactory() is 'SessionFactory' object.
		
   (2)SessionFactory:
   ------------------ 
     >It is an interface .
     >It is present in 'org.hibernate' package.
     >It reads the 'xml' file and provides connection to the database.
     >Using SessionFactory we obtain a component Session.
   
   (3)Session:
   -----------
    >It is an interface .
    >It is use to perfrom 'CRUD' operation.
    >To obtain Session object we have to use a helper method called as 'openSession()'.
    >This method is present in 'SessionFactory' object.	
	
	Note:-
	------
	 >An application should have only one SessionFactory.
	 >Session can be multiple.
	 >To save an object to database we have to use a method called as 'save(Ref DTOClass)'.
     >It is present in Session object.
     >By default commit is always false in hibernate whenever we have to commit the data to 
      database we have to mannually commit 'true' It is done by a component called as 'Transaction'.

    Transaction:
    ------------
     >It is an interface.
     >To obtain transaction we have to use a helper method called as 'beginTransaction()'.
     >This method is present in Session object.
     >Transaction is use whenever we are manipulating the content in the database.
     >It is required for Insert,Update and delete operations.
     >If we call save() method object is saved in hibernate cache memory.
      //Obtaining Transaction type object:
       Transaction tx=sess.beginTransaction();
	  //To begin Transaction 
	    tx.commit();
	 >Whenever we invoke save() method the object are saved to only in the hibernate cache memory
      to propagate the object with data to database we must do transaction.
     >To check the sql queries which hibernate is writting we have to use a <property> tag with
      name 'show_sql'
     >In xml file:
        <property name="show_sql">true</property>
      //We can see the query in the runtime console.
   
   >To Load the Data from database:
      1.To fetch record we don't want MusicDTO object only to insert we need a DTO object if we 
         create one more record is forward in table.
      2.To load a record from the database we use a method called as 'load()'.
       Syntax:
       -------
         sess.load(DTO.class,PK);//PK->column-name-->value of String. 	
        >It is present in session object.
        >It return DTO object.
         ex:
           MusicDTO music=sess.load(MusicDTO.class,"music_name"); 
        >we need make use of getter method present in DTO class to get the value of record.
         ex:
          Sop(music.getArtist());
		  
   >To update a record in the table we have to follow two steps:
     1.Load the records from the database and use setter method to set the value.
     2.Use update method.
     ex:
       MusicDTO music=sess.load(MusicDTO.class,pk column_name);
       music.setLength(5);
       music.setYOR(2016);
       sess.update(music);
       Transaction tx=sess.beginTransaction();
       tx.commit();

   >Instead developer setting the values for primary keys hibernate to generate value for primary 
     key. 
      eg.
        @Id
	    @GenericGenerator(name="generator",strategy="increment")
	    @GeneratedValue(generator="generator")
        private int id;

   >For Create table autometically.
     syntax:In xml file
	   <property name="hbm2ddl.auto">create/update</property>
	   ------------------------------------------------------
	 >When we use 'create' hibernate always drop the table and create new one to avoid droping
	  of table we have to use 'update'.
	  
   >Generate database autometically:
      syntax:In xml
        databaseName?createDatabaseIfNotExist=true
        ------------------------------------------

   >We Can load the mapping class in two ways:
     1.By using addAnnotedClass(DTOCLass.class) method.
     2.By using Mapping tag
        syntax:In xml
          <mapping class="fully qualify class name"/>
           -----------------------------------------

    >There are four ways to load the data from database:
      1.Using 'Load/Get'.
      2.SQL.
      3.HQL.
      4.Criteria.
	  
        >The disadvantage of 'load' method is we can not load multiple record from the table.
		
    3.HQL(Hibernate Query Language):
    --------------------------------
        >It is a query language in which we write the queries based on class and datamembers.
        >Diffrence Between HQL and SQL.
          1.Sql:DB dependent.
            Hql:DB independent.
          2.Sql:Relational Model.
            Hql:Object Model.
        >To use Hql we need to follow two steps:
           (1)Create the query.
		   --------------------
		      (a).To Create a query we have to use a method 'createQuery()'.
			  (b).It is Present in 'Session' object.
			  (c).This method return an object of 'Query'.
           (2)Process the Result.
           ----------------------
              >To process the result we have two methods.
               (a)uniqueResult():
			       >It is used when the query returns only one record.
				   >It returns an object.
               (b)list():
                  Both methods are present in 'Query' object .
              Note:
             ------	
                >Sql does not support 'select *'
              >To select a record from a table :
			     {
				    //Create query.
                    String hql="from DominoseDTO where noOfOreders=2";
					Query query=session.createQuery(hql);
					//Process the Result
					DominoseDTO dominose=(DominoseDTO)query.uniqueResult();
					Sop(dominose.getterMethods());
				 }
              >To load all Record from the DB.
                 {
				   String hql="from DominoseDTO";
				   Query qry=session.createQuery(hql);
				   //Process the result.
				   List<DominoseDTO> dominose=qry.list();
				   for(DominoseDTO dominoseDto:dominose)
				   {
				     Sop(dominoseDto.getterMethods());
				   }
				 }
              >To Select Single Column from the database.
                  {
				     String hql="select branch from DominoseDTO where noOfOreders=2";
					 Query qry=session.createQuery(hql);
					 //Process the result
					 String branch=(String)qry.uniqueResult();
					 Sop(branch);
				  }	
              >To Select Multiple Columns Record from Database.
                  {
				    String hql="select branch,contactNo from DominoseDTO where noOfOreders=2";
					Query qry=session.createQuery(hql);
					Object[] value=(Object[])qry.uniqueResult();
					Sop(value[0]);
					Sop(value[1]);
				  }
              >Dynamic Hql queries:
                 public class DynamicHqlDao
                 {
				    p s v m()
					{
					  //Get the session object.
					  String hql="from DominoseDTO where noOfOreders=? and branch=?
					  Query qry=session.createQuery(hql);
					  qry.setInteger(0,2);
					  qry.setString(1,"Basavangudi");
					  //Process the result.
					  DominoseDTO dominose=(DominoseDTO)qry.uniqueResult();
					  Sop(dominose.getCNo());
					}
				 }
              >Disadvantages of place holder:-
                (1).Developer has to remember the index of placeholder
                (2).We have to use appropreate setter method.
          
              >To overcome this disadvantage we use 'Named' parameter.
                  syntax:
                          =:variableName
                          --------------
                  eg:
                    Hql using Named:
                    {
					  hql="from DominoseDTO where noOfOreders=:noOfOreders and branch=:branch";
					  Query qry=session.createQuery(hql);
					  qry.setParameter("noOfOreders",2);
					  qry.setParameter("branch","Basavangudi");
					}
					
               IQ(Interview Questions):
                 1.What is hibernate?.
                 2.What are the components of hibernate?
                 3.Write hibernate configuration file to connect to mysql and oracle database.
                 4.What is hql and explain difference hql and sql?
                 5.Diffrence between 'load()' and 'get()'.
				 6.What is Transaction?and when it is used?
				 
              >To load data by load:
                class LoadGet
                {
				  p s v m()
				  {
				    ---
					---
					DominoseDTO dominose=session.get(DominoseDTO.class);
				  }
				}				
      	 Q4.Diffrence between 'load()' and 'get()'.
		 Ans:
		 1.
		   load():When the record does not exist in the database load return objectNotFoundException.
		   get():when the record is not present get method returns null.
		 2.
           load():load will not write any query to database instead it return a proxy object.
           get():always writes a select query to the database.

 NamedQuery:
------------
    >In NamedQuery we write query inside DTO class.
    >To use NamedQuery we have to follow two steps
      (1)Write the query in Dto.
      (2)Get the named query in the DAO class and process the result.
     syntax:
      @NamedQuery(name,query)
     eg.
      @Table(name=" ")
      @NamedQuery(name="getByNoofOrder", query="from DominoseDTO where noOfOreders=:noOfOreders")	  
--------------------------------------------------------------------------------------------------	 
 
Problem Of Relations:
---------------------
  > Problems of relations is mapping has a relationship to database.
  >To Provide solution for POR hibernate has provide four straitegy .
  (1)One-One
  (2)One-Many
  (3)Many-One
  (4)Many-Many
 (1)One-One Relationship:-
                 In one-one relationship one class will have reference of another 
        class only once.
        eg:One Country can have Only one flag.
    Steps to create a DAO:
	----------------------
	(a) Create an object of owning entity and populate the values.
	(b) Create an object of associated entity and populate the values.
	(c) Relate owning entity with the associated entity using setter method.
  Cascade:-
  ---------
      > Cascade is used to specify the operations that should be performed on associated entity.
	  > The Value for cascade is an enum type that is CascadeType.
  CascadeType:-
  -------------
      >CascadeType has constant like ALL Class,DETACH,MERGE,PERSIST,REFRESH,REMOVE.
      >In one to one bidirection where we use JoinColumn an extra column is created the values
        for previous record will be null hence to avoid null use an annotation
          -@PrimaryKeyJoinColumn.
          ----------------------
  LazyLoading:-
  -------------
     >Using LazyLoading we can control the objects that should be located from the database.
     >To Configure lazyloading we have to use an enum FETCHTYPE:
       FETCHTYPE has two constants
     (1)LAZY &
     (2)EAGER
          If we don't specify the fetchType by default it is always EAGER fetching.
		  
  (2)One To Many:
  ---------------
      One to many means is one class is having multiple references to another class.
    Steps to create one to many DAO:
    --------------------------------
    (a)Create an object of owning entity entity.
    (b)Create Multiple objects of associated entity.
    (c)Create a Collection of associated entities.
    (d)Relate owning entity with the collection of associated entity.
    (e)Use save method to save the owning entity.
	
  (3)Many to One Relationship:
  ----------------------------
        Many to One is the bidirection of one to many relationship. At the compile time many to
    one is same as one to one relationship.
   Steps to Create Many to One Relationship:-
   ------------------------------------------
    (a)Create Multiple objects owning entity.
    (b)Load the associated entity from the database.
    (c)Relate the owning entity with the associated entity.
    (d)Use Save method to save multiple owning entities.
	
  (4)Many to Many Relationship:
  -----------------------------
  
  Q 1What is POR and explain the straitegy?
  Ans:
  
  POI(problem of inheritance):Problem of inheritance is mapping  IS a relationship to database.
  ----------------------------
   >To provide the solution for POI hibernate has provided three straitegies:
   1.Table Per class.
   2.Single Table.
   3.Joined.
   
   1.Table Per class:
   ------------------
     >In this straitegy the no of tables will be equal to the no of dto.
     >Each dto is mapped to its own table .
	 
    The disadvantage of Table per class is:
    ---------------------------------------
   
    1.Since the no of table are equal to the no dto,n no of tables will generated for n no of classes.
    2.The colums of super class are repeated in every subclass table.
	
   2.Single Table straitegy:
   -------------------------
     >In this straitegy hibernate will create only one table.
     >And all the dto are mapped to a single table.
	 
    The disadvantage with Single Table straitegy :
	----------------------------------------------
	
    1.The Table contains lot of null values	hence not null constraint can not be added.
	2.
	
   3.Joined straitegy:
   -------------------
	   > In this straitegy the no of tables are equal to the no of dtos but colums are not repeated .
	   > The tables are normalized.
	   
 There are five core apis in hibernate:
 --------------------------------------
    1.Criteria
    2.Criterion
    3.Restrictions
    4.Projections
    5.Order
 1.Criteria:
 -----------
       >It is an api which is used to load objects from the database based on some conditions.
       >To use Criteria we have to follow two steps:
         (a)Create the criteria.
         (b)Process the result.
          >To create the criteria we have to use a method called as 'createCriteria()'.
          >It is present in session object.	
          >The Return type of createCriteria is 'Criteria' object.
		  
    select all the records:
     Criteria crit=session.createCriteria(DTOCLass.class) ;
     //for any conditions....
     Restriction.eq("brand","Nerolac");
     //process the result.
     List<PaintDTO> l1=crit.list();
     for(PaintDTO p1:l1)
     {
       sop(p1.getBrand);
     }
  
 3.Restricton:
 -------------
       >It is an api which is used to add the conditions to the criteria.
       >Restriction is a class which has some static method like
          eq,gt,ge.....	
       >Restricton.xx method returns an object of 'Criterion'.
       >Criterion is same as where clause in sql.
       >To relate Criteria with Criterion we use a method called as add it is present in Criteria object.
         crit.add(criterion);	   
	
    Select One record from database:
    --------------------------------
       Criteria crit=session.createCriteria(PaintDTO.class);
       //Where clause
       Criterion criterion=Restrictions.eq("brand","Nerolac");
       //relate criteria with criterion.
         crit.add(criterion);
		 List<PaintDTO> l1=crit.list();
         for(PaintDTO p1:l1)
         {
            sop(p1.getBrand);
         }
    Add multiple conditions to criteria:
    ------------------------------------
      Criterion crit1=Restrictions.ge("price",3000);
      Criterion crit2=Restrictions.eq("brand","berger");
      crit.add(crit1);
      crit.add(crit2);
	  
    'OR' Operation:
    ---------------
	//select * from paint_table where condition
	Criteria crit=sess.createCriteria(PaintDTO.class);
    //add 1st conditions
    Criterion criterion1= Restrictions.lt("price",3000);
    //add 2nd conditions
    Criterion criterion2=Restrictions.lt("brand","berger");
	//To do or operation
	LogicalExpression exp=Restrictions.or(criterion1,criterion2);
	//Relate criteria with expression
	crit.add(exp);
	
	4.Projections(Interface):
	-------------------------
	     >It is an api which is use to execute group function like avg,max,min,etc.
	     >To execute group function hibernate has provided a class called as Projections
		   which has some static methods like max(),min(),roecount() etc..
		   
	To use Projections we have to follow three steps:
	-------------------------------------------------
    1.create Criteria.
    2.Use Projections.xx method	to obtain Projection
	3.Relate Criteria with Projection use a method called as 
	    criteria.setProjection()
		ex:
		class UseintgProjections
		{
		   //get session object.
		   //step 1 create criteria
		   Criteria crit=sess.createCriteria(PaintDTO.class);
		   //step 2 obtain Projection object
		   Projection pro=Projections.max("price");
		   
		   //step 3. relate criteria with projection
		   crit.setProjection(pro);
		   Integer maxPrice=(Integer)crit.uniqueResult();
		   System.out.println(maxPrice);
		  //For avg price.
		   Projection pro=Projections.avg("price");
		   crit.setProjection(pro);
		   Double avgP=(Double).crit.uniqueResult();
		   syso(avgP);
		   //Count total row.
		   Projection pro=Projections.rowCount();
		   crit.setProjection(pro);
		   Long rowcount=(Long).crit.uniqueResult();
		   Sop(rowcount);
		}
	5.Order:
	--------
      >It is an api which is use to sort the data in ascending or descending oredr.
      > To use order we have to follow three steps
       1.Create Criteria
       2.Use Order.asc or Order.desc method to obtain Order  object
       3.Relate Criteria with order by using a  method called as addOrder().
        ex:
        class UsingOrder
        {
		   p s v m()
		   {
		     //obtain the session.
			 //step 1 Create criteria object
			 Criteria crit=sess.createCriteria(PaintDTO.class);
			 //step 2 obtain order object
			 Order ord= Order.asc("price");
			 //step 3 Relate criteria with order
			 crit.addOrder(ord);
			 //process the result using list method().
			 List<PaintDTO.class> paint=crit.list();
			 for(PaintDTO p1:paint)
			 {
			    Sop(p1.getPrice());
			 }
		   }
		}
		
    Pagination Using Criteria:
	--------------------------
	  >To Paginate result hibernate has provided an api called as Criteria.
	  >To Paginate the result we have use two methods 
	    1.setFirstResult(int al)
		2.setMaxResult(int all)
		ex:
		class Pagination
		{
		   //get session object.
		   //Create criteria
		   Criteria crit=sess.createCriteria(PaintDTO.class);
		   //Pagination
		   crit.setFirstResult(0);
		  //count of number of records
		    crit.setMaxResult(2);
		  //process the result
          List<PaintDTO> list=crit.list();		  
		}
      1.setFirstResult():This method accepts an integer which specify index fro where the data should
		  fetch.
	  2.setMaxResult():This method accepts an integer which specifis the count of no of records to
	      be fetch.	  
	 ----------------------------------------------------------------------------
   html file:
   <html>
   <form action="Booking">
   Movie Name:<input type="text" name="name">
   Language:<input type="text" name="language">
   No of Seats:<input type="number" name="number">
   
   <button type="submit">
   <button type="reset" name"reset">
   </form>
   </html>
   //CreateServlet
   @WebServlet("/Booking")   
   class MovieControler extends HttpServlet
   {
      doGet(SR req,SQL res)
	  {
	   String name= req.getParameter("name");
	   String language= req.getParameter("language");
	   int noOfSeats= Integer.parseInt(req.getParameter("number"));
	    sop(name);
		sop(language);
		sop(noOfSeats);
		//create object of dto and populate the value
		movie=new MovieDTO();
		movie.setNmae("hjh");
		movie.setLanguage("hjh");
		movie.setNoOfSeats(2);
		MovieDAO movieDao=new MovieDAO();
		movieDao.saveMovie(movie);
	  }
   }
   //Create dto class
   @Tbale(name="movie_table")
   class MovieDTO 
   {
	  @Column("movie_name")
      private String movie_name;
	  @Column("movie_language")
	  private String language;
	  @Column("no_of_seats")
	  private int noOfSeats;
	  @GenericGenerator(name="gen",straitegy="increament")
	  @GeneratedValue()
	  //getters setter.
   }
   //Create DAO Class..
   class MovieDAO
   {
      
	    //method accepts a dto object
		p v saveMovie(MovieDTO dto)
		{
		   sop(dto.getName())
		   sop(dto.getLanguage())
		   sop(dto.getNoOfSeats())*/
		   //component of hibernate
		   //get session object
		   sess.save(dto);
		   sess.beginTransaction().commit();
		}
	  
   }
   //ctr+shift+n
 -----------------------------------End Of Hibernate----------------------------------------------
	 
	

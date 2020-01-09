import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.util.Scanner;
import userdetails;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main
{
	public static void customer_entry(String name, String add, int cat)//Defining class for Procedure 1
	{ 
        String query = "{ call customer_entry(?, ?, ?) }"; //Calling procedure #1
        ResultSet rs;
        // Connect to database
        final String hostName = "potd0000-sql-server.database.windows.net"; 
        final String dbName = "cs-dsa-4513-sql-db";
        final String user = "potd0000";
        final String password = userdetails.password;
        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        try 
        (final Connection connection = DriverManager.getConnection(url)) 
        {
        	final String schema = connection.getSchema(); 
        	System.out.println("Successful connection - Schema:" + schema); 
        	System.out.println("Inserting Customer:"+name);
            try
            (final Connection conn = DriverManager.getConnection(url);
            		CallableStatement stmt = conn.prepareCall(query))
            {
            											//Providing parameters to the procedure
            	stmt.setString(1, name);
            	stmt.setString(2, add);
            	stmt.setInt(3, cat);
            	rs = stmt.executeQuery();				//Query execution
            	}
            catch (SQLException ex)
            {
            	System.out.println(ex.getMessage());
            	}
            }
        catch (SQLException e)
        {
			throw new RuntimeException(e);
		}
        }
	
	public static void department_entry(int num, String data)//Defining class for Procedure 2
	{ 
        String query = "{ call department_entry(?,?) }";//Calling procedure #2
        ResultSet rs;
        												// Connect to database
        final String hostName = "potd0000-sql-server.database.windows.net"; 
        final String dbName = "cs-dsa-4513-sql-db";
        final String user = "potd0000";
        final String password = userdetails.password;        
        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        try 
        (final Connection connection = DriverManager.getConnection(url)) 
        {
        	final String schema = connection.getSchema(); 
        	System.out.println("Successful connection - Schema:" + schema); 
        	System.out.println("Inserting Department number: "+num); 
        	try
            (final Connection conn = DriverManager.getConnection(url);
            		CallableStatement stmt = conn.prepareCall(query))
            {
        												//Providing parameters to the procedure
            	stmt.setInt(1, num);
            	stmt.setString(2, data);
            	rs = stmt.executeQuery();				//Query execution
            }
            catch (SQLException ex)
            {
            	System.out.println(ex.getMessage());
            }
        }
        catch (SQLException e)
        {
			throw new RuntimeException(e);
		}
    }
	
	public static void assembly_entry(String id, String date, String details, String name)		
	{
		String query = "{ call assembly_entry(?,?,?,?) }";//Calling procedure #3
        ResultSet rs;
        												// Connect to database
        final String hostName = "potd0000-sql-server.database.windows.net"; 
        final String dbName = "cs-dsa-4513-sql-db";
        final String user = "potd0000";
        final String password = userdetails.password;        
        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        try 
        (final Connection connection = DriverManager.getConnection(url)) 
        {
        	final String schema = connection.getSchema(); 
        	System.out.println("Successful connection - Schema:" + schema); 
        	System.out.println("Inserting Assembly details for customer: "+name); 
        	try
            (final Connection conn = DriverManager.getConnection(url);
            		CallableStatement stmt = conn.prepareCall(query))
            {
        												//Providing parameters to the procedure
            	stmt.setString(1, id);
            	stmt.setString(2, date);
            	stmt.setString(3, details);
            	stmt.setString(4, name);
            	rs = stmt.executeQuery();				//Query execution
            }
            catch (SQLException ex)
            {
            	System.out.println(ex.getMessage());
            }
        }
        catch (SQLException e)
        {
			throw new RuntimeException(e);
		}
    }
	
	public static void process_entry(String id, String details, int num)		
	{
		String query = "{ call process_entry(?,?,?) }";//Calling procedure #4
        ResultSet rs;
        												// Connect to database
        final String hostName = "potd0000-sql-server.database.windows.net"; 
        final String dbName = "cs-dsa-4513-sql-db";
        final String user = "potd0000";
        final String password = userdetails.password;        
        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        try 
        (final Connection connection = DriverManager.getConnection(url)) 
        {
        	final String schema = connection.getSchema(); 
        	System.out.println("Successful connection - Schema:" + schema); 
        	System.out.println("Inserting Process details for department no.: "+num); 
        	try
            (final Connection conn = DriverManager.getConnection(url);
            		CallableStatement stmt = conn.prepareCall(query))
            {
        												//Providing parameters to the procedure
            	stmt.setString(1, id);
            	stmt.setString(2, details);
            	stmt.setInt(3, num);
            	rs = stmt.executeQuery();				//Query execution
            }
            catch (SQLException ex)
            {
            	System.out.println(ex.getMessage());
            }
        }
        catch (SQLException e)
        {
			throw new RuntimeException(e);
		}
    }
	
	public static void account_entry(int num, String date, int ch, int cost, int id, String id2)		//Account parent entry
	{
		String query = "{ call account_entry(?,?) }";//Calling procedure #5
		
		ResultSet rs;
		ResultSet rs1;
        												// Connect to database
        final String hostName = "potd0000-sql-server.database.windows.net"; 
        final String dbName = "cs-dsa-4513-sql-db";
        final String user = "potd0000";
        final String password = userdetails.password;        
        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        try 
        (final Connection connection = DriverManager.getConnection(url)) 
        {
        	final String schema = connection.getSchema(); 
        	System.out.println("Successful connection - Schema:" + schema); 
        	System.out.println("Inserting Account details(parent) for acc.no: "+num); 
        	try(final Connection conn = DriverManager.getConnection(url);
            		CallableStatement stmt = conn.prepareCall(query))
            {
        												//Providing parameters to the procedure
            	stmt.setInt(1, num);
            	stmt.setString(2, date);
            	rs = stmt.executeQuery();				//Query execution
            }
            catch (SQLException ex)
            {
            	System.out.println(ex.getMessage());
            }
	      	System.out.println("Inserting Account details(child) for acc.no: "+num); 
        	if (ch==3)
        	{
        		String query1= "{ call department_account_entry(?,?,?) }";//Calling procedure #5
        		try(final Connection conn = DriverManager.getConnection(url);
                		CallableStatement stmt1 = conn.prepareCall(query1))
                {
            												//Providing parameters to the procedure
                	stmt1.setInt(1, num);
                	stmt1.setInt(2, cost);
                	stmt1.setInt(3, id);
                	rs = stmt1.executeQuery();				//Query execution
                }
        		catch (SQLException ex)
                {
                	System.out.println(ex.getMessage());
                }
        	}
        	else if(ch == 1)
        	{
        		String query2 = "{ call assembly_account_entry(?,?,?) }";//Calling procedure #5
        		try(final Connection conn = DriverManager.getConnection(url);
                		CallableStatement stmt2 = conn.prepareCall(query2))
                {
            												//Providing parameters to the procedure
                	stmt2.setInt(1, num);
                	stmt2.setInt(2, cost);
                	stmt2.setString(3, id2);
                	rs1 = stmt2.executeQuery();				//Query execution
                }
        		catch (SQLException ex)
                {
                	System.out.println(ex.getMessage());
                }
        	}
        	else
        	{
        		String query2="{ call process_account_entry(?,?,?) }";//Calling procedure #5
        		try(final Connection conn = DriverManager.getConnection(url);
                		CallableStatement stmt2 = conn.prepareCall(query2))
                {
            												//Providing parameters to the procedure
                	stmt2.setInt(1, num);
                	stmt2.setInt(2, cost);
                	stmt2.setString(3, id2);
                	rs1 = stmt2.executeQuery();				//Query execution
                }
        		catch (SQLException ex)
                {
                	System.out.println(ex.getMessage());
                }
        	}
        		        	
    	}
        catch (SQLException e)
        {
			throw new RuntimeException(e);
		}
    }

	public static void job_entry(int num, String date, String a_id, String p_id)		
	{
		String query = "{ call job_entry(?,?,?,?) }";//Calling procedure #4
        ResultSet rs;
        												// Connect to database
        final String hostName = "potd0000-sql-server.database.windows.net"; 
        final String dbName = "cs-dsa-4513-sql-db";
        final String user = "potd0000";
        final String password = userdetails.password;        
        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        try 
        (final Connection connection = DriverManager.getConnection(url)) 
        {
        	final String schema = connection.getSchema(); 
        	System.out.println("Successful connection - Schema:" + schema); 
        	System.out.println("Inserting Job details for job no.: "+num); 
        	try
            (final Connection conn = DriverManager.getConnection(url);
            		CallableStatement stmt = conn.prepareCall(query))
            {
        												//Providing parameters to the procedure
            	stmt.setInt(1, num);
            	stmt.setString(2, date);
            	stmt.setString(3, a_id);
            	stmt.setString(4, p_id);
            	rs = stmt.executeQuery();				//Query execution
            }
            catch (SQLException ex)
            {
            	System.out.println(ex.getMessage());
            }
        }
        catch (SQLException e)
        {
			throw new RuntimeException(e);
		}
    }
	
	public static void fit_job_completion(int num, String l_time, String date)		
	{
		String query = "{ call fit_job_completion(?,?,?) }";//Calling procedure #4
        ResultSet rs;
        												// Connect to database
        final String hostName = "potd0000-sql-server.database.windows.net"; 
        final String dbName = "cs-dsa-4513-sql-db";
        final String user = "potd0000";
        final String password = userdetails.password;        
        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        try 
        (final Connection connection = DriverManager.getConnection(url)) 
        {
        	final String schema = connection.getSchema(); 
        	System.out.println("Successful connection - Schema:" + schema); 
        	System.out.println("Inserting Job details for fit job.: "); 
        	try
            (final Connection conn = DriverManager.getConnection(url);
            		CallableStatement stmt = conn.prepareCall(query))
            {
        												//Providing parameters to the procedure
            	stmt.setInt(1, num);
            	stmt.setString(2, l_time);
            	stmt.setString(3, date);
            	rs = stmt.executeQuery();				//Query execution
            }
            catch (SQLException ex)
            {
            	System.out.println(ex.getMessage());
            }
        }
        catch (SQLException e)
        {
			throw new RuntimeException(e);
		}
    }
	
	public static void paint_job_completion(int num, String col, int vol, String l_time, String date)		
	{
		String query = "{ call paint_job_completion(?,?,?,?,?) }";//Calling procedure #4
        ResultSet rs;
        												// Connect to database
        final String hostName = "potd0000-sql-server.database.windows.net"; 
        final String dbName = "cs-dsa-4513-sql-db";
        final String user = "potd0000";
        final String password = userdetails.password;        
        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        try 
        (final Connection connection = DriverManager.getConnection(url)) 
        {
        	final String schema = connection.getSchema(); 
        	System.out.println("Successful connection - Schema:" + schema); 
        	System.out.println("Inserting Job details for paint job"); 
        	try
            (final Connection conn = DriverManager.getConnection(url);
            		CallableStatement stmt = conn.prepareCall(query))
            {
        												//Providing parameters to the procedure
            	stmt.setInt(1, num);
            	stmt.setString(2, col);
            	stmt.setInt(3, vol);
            	stmt.setString(4, l_time);
            	stmt.setString(5, date);
            	rs = stmt.executeQuery();				//Query execution
            }
            catch (SQLException ex)
            {
            	System.out.println(ex.getMessage());
            }
        }
        catch (SQLException e)
        {
			throw new RuntimeException(e);
		}
    }
	
	public static void cut_job_completion(int num, String typ, String a_time, String mat, String l_time, String date)		
	{
		String query = "{ call cut_job_completion(?,?,?,?,?,?) }";//Calling procedure #4
        ResultSet rs;
        												// Connect to database
        final String hostName = "potd0000-sql-server.database.windows.net"; 
        final String dbName = "cs-dsa-4513-sql-db";
        final String user = "potd0000";
        final String password = userdetails.password;        
        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        try 
        (final Connection connection = DriverManager.getConnection(url)) 
        {
        	final String schema = connection.getSchema(); 
        	System.out.println("Successful connection - Schema:" + schema); 
        	System.out.println("Inserting Job details for cut job"); 
        	try
            (final Connection conn = DriverManager.getConnection(url);
            		CallableStatement stmt = conn.prepareCall(query))
            {
        												//Providing parameters to the procedure
            	stmt.setInt(1, num);
            	stmt.setString(2, typ);
            	stmt.setString(3, a_time);
            	stmt.setString(4, mat);
            	stmt.setString(5, l_time);
            	stmt.setString(6, date);
            	rs = stmt.executeQuery();				//Query execution
            }
            catch (SQLException ex)
            {
            	System.out.println(ex.getMessage());
            }
        }
        catch (SQLException e)
        {
			throw new RuntimeException(e);
		}
    }
	
	public static void updates_entry(int t_num, int s_cost, int j_num)		
	{
		String query = "{ call cost_transaction_record_entry(?,?,?) }";//Calling procedure #8 1st part
		String query1 = "{ call updates_entry(?) }";//Calling procedure #8 Part 2
        ResultSet rs;
        												// Connect to database
        final String hostName = "potd0000-sql-server.database.windows.net"; 
        final String dbName = "cs-dsa-4513-sql-db";
        final String user = "potd0000";
        final String password = userdetails.password;        
        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        try 
        (final Connection connection = DriverManager.getConnection(url)) 
        {
        	final String schema = connection.getSchema(); 
        	System.out.println("Successful connection - Schema:" + schema); 
        	System.out.println("Inserting Transaction details for job"); 
        	try
            (final Connection conn = DriverManager.getConnection(url);
            		CallableStatement stmt = conn.prepareCall(query))
            {
        												//Providing parameters to the procedure sub part 1
            	stmt.setInt(1, t_num);
            	stmt.setInt(2, s_cost);					// Taking entry for transactions
            	stmt.setInt(3, j_num);
            	rs = stmt.executeQuery();				//Query execution
            }
            catch (SQLException ex)
            {
            	System.out.println(ex.getMessage());
            }
        	try
            (final Connection conn = DriverManager.getConnection(url);
            		CallableStatement stmt1 = conn.prepareCall(query1))
            {
        												//Providing parameters to the procedure sub part 2
            	stmt1.setInt(1, t_num);
            	rs = stmt1.executeQuery();				//Query execution to update cost
            }
        	catch (SQLException ex)
            {
            	System.out.println(ex.getMessage());
            }
        }
        catch (SQLException e)
        {
			throw new RuntimeException(e);
		}
    }
	
	public static void cost_assembly_retrieve(String a_id)		
	{
		String query = "{ call cost_assembly_retrieve(?) }";//Calling procedure #9
        ResultSet rs;
        												// Connect to database
        final String hostName = "potd0000-sql-server.database.windows.net"; 
        final String dbName = "cs-dsa-4513-sql-db";
        final String user = "potd0000";
        final String password = userdetails.password;        
        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        try (final Connection connection = DriverManager.getConnection(url)) 
        {
            final String schema = connection.getSchema();
            System.out.println("Successful connection - Schema:" + schema);
            System.out.println("=========================================");
            try 
            (final Connection conn = DriverManager.getConnection(url);
            		CallableStatement resultset = conn.prepareCall(query))
            {
            	resultset.setString(1, a_id);  // Taking input for query
            	rs = resultset.executeQuery();	// Execution
            	System.out.println("Retrieving the Cost for assembly_id: "+ a_id);
            	while (rs.next()) 
            	{			//Displaying table from SQL database
            		System.out.println(String.format("%f ",rs.getFloat(1)));		//Printing the result
            	}
            } 
            catch (SQLException e) 
    		{
				throw new RuntimeException(e);
			}

        } 
        catch (SQLException e1) 
        {
        	throw new RuntimeException(e1);
        }
	}
       	
	public static void labor_time_retrieve(String date,int d_num)	
	{
		String query = "{ call labor_time_retrieve(?,?) }";//Calling procedure #10
        ResultSet rs;
        												// Connect to database
        final String hostName = "potd0000-sql-server.database.windows.net"; 
        final String dbName = "cs-dsa-4513-sql-db";
        final String user = "potd0000";
        final String password = userdetails.password;        
        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        try (final Connection connection = DriverManager.getConnection(url)) 
        {
            final String schema = connection.getSchema();
            System.out.println("Successful connection - Schema:" + schema);
            System.out.println("=========================================");
            //final String selectSql = "SELECT * FROM Performer";
           
            try 
            (final Connection conn = DriverManager.getConnection(url);
            		CallableStatement resultset = conn.prepareCall(query))
            {
            	resultset.setString(1, date);  // Taking input for query
            	resultset.setInt(2, d_num);
            	rs = resultset.executeQuery();
            	//resultset.getInt(1);			// Execution
            	System.out.println("Retrieving the Total time for date: "
            	+ date + "and department number: "+d_num);
            	//System.out.println(String.format("%d ",rs.getInt(1)));		//Printing the result
            	while (rs.next()) 
            	{			//Displaying table from SQL database
            		System.out.println(String.format("%d ",rs.getInt(1)));		//Printing the result
            	}
            } 
            catch (SQLException e) 
    		{
				throw new RuntimeException(e);
			}

        } 
        catch (SQLException e1) 
        {
        	throw new RuntimeException(e1);
        }
	}
	
	public static void job_retrieve(String date,int dnum,int typ)		
	{
		String query;
        ResultSet rs;
        												// Connect to database
        final String hostName = "potd0000-sql-server.database.windows.net"; 
        final String dbName = "cs-dsa-4513-sql-db";
        final String user = "potd0000";
        final String password = userdetails.password;        
        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        try (final Connection connection = DriverManager.getConnection(url)) 
        {
            final String schema = connection.getSchema();
            System.out.println("Successful connection - Schema:" + schema);
            System.out.println("=========================================");
            if (typ == 1)
            {
            	query = "{ call fit_job_retrieve(?,?) }";//Calling sub procedure for queryy 12
                try 
                (final Connection conn = DriverManager.getConnection(url);
                		CallableStatement resultset = conn.prepareCall(query))
                {
                	resultset.setString(1, date);  // Taking input for query
                	resultset.setInt(2, dnum);
                	rs = resultset.executeQuery();	// Execution
                	System.out.println("Retrieving the job info and assembly_ids");
                	while (rs.next()) 
                	{			//Displaying table from SQL database
                		System.out.println(String.format("%d |%s |%s |%s |",
                				rs.getInt(1),
                				rs.getString(2),
                				rs.getString(3),
                				rs.getString(4)));		//Printing the result
                	}
                } 
                catch (SQLException e) 
        		{
    				throw new RuntimeException(e);
    			}
            }
            else if (typ == 2)
            {
            	query = "{ call paint_job_retrieve(?,?) }";//Calling sub procedure for queryy 12
                try 
                (final Connection conn = DriverManager.getConnection(url);
                		CallableStatement resultset = conn.prepareCall(query))
                {
                	resultset.setString(1, date);  // Taking input for query
                	resultset.setInt(2, dnum);
                	rs = resultset.executeQuery();	// Execution
                	System.out.println("Retrieving the job info and assembly_ids");
                	while (rs.next()) 
                	{			//Displaying table from SQL database
                		System.out.println(String.format("%d |%s |%d |%s |%s |%s |",
                				rs.getInt(1),
                				rs.getString(2),
                				rs.getInt(3),
                				rs.getString(4),
                				rs.getString(5),
                				rs.getString(6)));		//Printing the result
                	}
                } 
                catch (SQLException e) 
        		{
    				throw new RuntimeException(e);
    			}
            }
            else
            {
            	query = "{ call cut_job_retrieve(?,?) }";//Calling sub procedure for query 12
            	try 
                (final Connection conn = DriverManager.getConnection(url);
                		CallableStatement resultset = conn.prepareCall(query))
                {
                	resultset.setString(1, date);  // Taking input for query
                	resultset.setInt(2, dnum);
                	rs = resultset.executeQuery();	// Execution
                	System.out.println("Retrieving the job info and assembly_ids");
                	while (rs.next()) 
                	{			//Displaying table from SQL database
                		System.out.println(String.format("%d |%s |%s |%s |%s |%s |",
                				rs.getInt(1),
                				rs.getString(2),
                				rs.getString(3),
                				rs.getString(4),
                				rs.getString(5),
                				rs.getString(6)));		//Printing the result
                	}
                } 
                catch (SQLException e) 
        		{
    				throw new RuntimeException(e);
    			}
            }

        } 
        catch (SQLException e1) 
        {
        	throw new RuntimeException(e1);
        }
	}
	
	public static void customer_retrieve(int st,int end)		
	{
		String query = "{ call customer_retrieve(?,?) }";//Calling procedure #9
        ResultSet rs;
        												// Connect to database
        final String hostName = "potd0000-sql-server.database.windows.net"; 
        final String dbName = "cs-dsa-4513-sql-db";
        final String user = "potd0000";
        final String password = userdetails.password;        
        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        try (final Connection connection = DriverManager.getConnection(url)) 
        {
            final String schema = connection.getSchema();
            System.out.println("Successful connection - Schema:" + schema);
            System.out.println("=========================================");
            try 
            (final Connection conn = DriverManager.getConnection(url);
            		CallableStatement resultset = conn.prepareCall(query))
            {
            	resultset.setInt(1,st);
            	resultset.setInt(2,end); // Taking input for query
            	rs = resultset.executeQuery();	// Execution
            	System.out.println("Retrieving the customer names in the range: ");
            	while (rs.next()) 
            	{			//Displaying table from SQL database
            		System.out.println(String.format("%s |%s |%d |",
            				rs.getString(1),
            				rs.getString(2),
            				rs.getInt(3)));		//Printing the result
            	}
            } 
            catch (SQLException e) 
    		{
				throw new RuntimeException(e);
			}

        } 
        catch (SQLException e1) 
        {
        	throw new RuntimeException(e1);
        }
	}
	
	public static void cut_job_deletion(int st, int end)		
	{
		String query = "{ call cut_job_deletion(?,?) }";//Calling procedure #4
		ResultSet rs;
		// Connect to database
        final String hostName = "potd0000-sql-server.database.windows.net"; 
        final String dbName = "cs-dsa-4513-sql-db";
        final String user = "potd0000";
        final String password = userdetails.password;        
        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        try 
        (final Connection connection = DriverManager.getConnection(url)) 
        {
        	final String schema = connection.getSchema(); 
        	System.out.println("Successful connection - Schema:" + schema); 
        	System.out.println("Deleting cut job: "); 
        	try
            (final Connection conn = DriverManager.getConnection(url);
            		CallableStatement stmt = conn.prepareCall(query))
            {
        												//Providing parameters to the procedure
            	stmt.setInt(1, st);
            	stmt.setInt(2, end);
            	rs = stmt.executeQuery();				//Query execution
            }
            catch (SQLException ex)
            {
            	System.out.println(ex.getMessage());
            }
        }
        catch (SQLException e)
        {
			throw new RuntimeException(e);
		}
    }

	public static void color_change(String col, int j_num)		
	{
		String query = "{ call color_change(?,?) }";//Calling procedure #4
		ResultSet rs;
		// Connect to database
        final String hostName = "potd0000-sql-server.database.windows.net"; 
        final String dbName = "cs-dsa-4513-sql-db";
        final String user = "potd0000";
        final String password = userdetails.password;        
        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        try 
        (final Connection connection = DriverManager.getConnection(url)) 
        {
        	final String schema = connection.getSchema(); 
        	System.out.println("Successful connection - Schema:" + schema); 
        	System.out.println("Change the color of job no.: "+j_num); 
        	try
            (final Connection conn = DriverManager.getConnection(url);
            		CallableStatement stmt = conn.prepareCall(query))
            {
        												//Providing parameters to the procedure
            	stmt.setString(1, col);
            	stmt.setInt(2, j_num);
            	rs = stmt.executeQuery();				//Query execution
            }
            catch (SQLException ex)
            {
            	System.out.println(ex.getMessage());
            }
        }
        catch (SQLException e)
        {
			throw new RuntimeException(e);
		}
    }
	
	public static void take_input(String filename)		
	{
		String csvFile = filename;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try 
        {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) 
            {

                // use comma as separator
                String[] file = line.split(cvsSplitBy);
                String name = file[0];
                String add = file[1];
                int cat = Integer.parseInt(file[2]);
                
                customer_entry(name,add,cat);

            }

        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            if (br != null) 
            {
                try 
                {
                    br.close();
                } catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
        }
    }

	public static void export_customer(int st,int end) throws IOException		
	{
		String query = "{ call customer_retrieve(?,?) }";//Calling procedure #9
        ResultSet rs;
        												// Connect to database
		String trial = "C:/Users/akhil/eclipse-workspace/HW3/src/output.txt";
        final String hostName = "potd0000-sql-server.database.windows.net"; 
        final String dbName = "cs-dsa-4513-sql-db";
        final String user = "potd0000";
        final String password = userdetails.password;        
        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        FileWriter fstream = new FileWriter(trial);
		BufferedWriter out = new BufferedWriter(fstream);
        try (final Connection connection = DriverManager.getConnection(url)) 
        {
            final String schema = connection.getSchema();
            System.out.println("Successful connection - Schema:" + schema);
            System.out.println("=========================================");
            try 
            (final Connection conn = DriverManager.getConnection(url);
            		CallableStatement resultset = conn.prepareCall(query))
            {
            	resultset.setInt(1,st);
            	resultset.setInt(2,end); // Taking input for query
            	rs = resultset.executeQuery();	// Execution
            	System.out.println("Retrieving the customer names in the range: ");
            	while (rs.next()) {            
    		        out.write(rs.getString(1) + ", ");
    		        out.write(rs.getString(2) + ", ");
    		        out.write(rs.getInt(3) + ", ");
    		        out.newLine();
    		        /*out.write(System.getProperty("line.separator"));*/
    			}
    			System.out.println("Completed writing into text file");
    			out.close();
            } 
            catch (SQLException e) 
    		{
				throw new RuntimeException(e);
			}

        } 
        catch (SQLException e1) 
        {
        	throw new RuntimeException(e1);
        }
    }
	

	public static void retrieve_process(String a_id)		
	{
		String query = "{ call retrieve_process(?) }";//Calling procedure #9
        ResultSet rs;
        												// Connect to database
        final String hostName = "potd0000-sql-server.database.windows.net"; 
        final String dbName = "cs-dsa-4513-sql-db";
        final String user = "potd0000";
        final String password = userdetails.password;        
        final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        try (final Connection connection = DriverManager.getConnection(url)) 
        {
            final String schema = connection.getSchema();
            System.out.println("Successful connection - Schema:" + schema);
            System.out.println("=========================================");
            try 
            (final Connection conn = DriverManager.getConnection(url);
            		CallableStatement resultset = conn.prepareCall(query))
            {
            	resultset.setString(1, a_id);  // Taking input for query
            	rs = resultset.executeQuery();	// Execution
            	System.out.println("Retrieving the Cost for assembly_id: "+ a_id);
            	while (rs.next()) 
            	{			//Displaying table from SQL database
            		System.out.println(String.format("%s ",rs.getString(1)));		//Printing the result
            	}
            } 
            catch (SQLException e) 
    		{
				throw new RuntimeException(e);
			}

        } 
        catch (SQLException e1) 
        {
        	throw new RuntimeException(e1);
        }
	}
	
	public static void main(String[] args) throws IOException
	{
		String nl = System.getProperty("line.separator");	//Defining line separator 
		System.out.println("1. Enter Customer information" + nl + "2. Enter Department details" 
		+ nl + "3. Entry Assembly table" + nl + "4. Enter Process table" 
		+ nl + "5. Enter Account information" + nl+ "6. Enter Job Information (Assigned Table) "
		+ nl + "7. Enter Job Completion Data & Info"+nl + "8. Insert transaction info and update accounts"
		+nl+ "9. Retrieve cost for the assembly"+nl+ "10. Retrive total labor time for a given date"
		+nl+ "11. Retrieve the Process and related Department accessed by an assembly" 
		+nl+ "12. Retrieve a job information and the assembly id given a date and department"
		+nl+ "13. Retrieve customer information for a category range"
		+nl+ "14. Delete cut-jobs in a given job number range"
		+nl+ "15. Change the color of a paint job" 
		+nl+ "16. Import new customer details from data file"
		+nl+ "17. Export retrieved customer data in a category range"
		+nl+ "18. Quit");
		
		while (true)
		{
			 
			System.out.println("Please Enter Option Number: ");//Obtaining user input for option
			Scanner user_input = new Scanner(System.in);
			int option = user_input.nextInt();

			if (option == 1)
			{
				
				System.out.println("Enter Customer Name: ");//Customer name as PK
				user_input.nextLine();
				String name = user_input.nextLine();
				
				
				System.out.println("Enter Customer Address: ");//Customer Address entry
				String add = user_input.nextLine();
				
				System.out.println("Enter Customer Category: ");//Customer category input
				int cat = user_input.nextInt();
				
				customer_entry(name, add, cat);//Providing input to procedure for query 1
			}
			else if (option == 2)
			{
				System.out.println("Enter Department number: ");//Department number as PK
				int d_num = user_input.nextInt();
				
				System.out.println("Enter information about the department: ");//Department info, about the work that goes on
				user_input.nextLine();
				String data = user_input.nextLine();
				
				department_entry(d_num, data);//Providing input to procedure 2
			}
			else if (option == 3)
			{	
				System.out.println("Enter Assembly ID: ");//Assembly ID entry
				String id = user_input.next();
				
				System.out.println("Enter date of ordering: ");//Customer Address entry
				String date = user_input.next();
				
				System.out.println("Enter assembly details: ");//assembly details input
				user_input.nextLine();
				String details = user_input.nextLine();
				
				System.out.println("Enter Customer name for whom the assembly is ordered: ");//Customer name as PK
				String name = user_input.next();
				
				assembly_entry(id, date, details, name);//Providing input to procedure for query 1
			}
			
			else if (option == 4)
			{	
				System.out.println("Enter Process ID: ");//Process ID entry
				String id = user_input.next();
				
				System.out.println("Enter data about the process : ");//Process data entry
				user_input.nextLine();
				String data = user_input.nextLine();
				
				System.out.println("Enter department number overseeing this process: ");//department input
				int num = user_input.nextInt();
				
				process_entry(id, data, num);//Providing input to procedure for query 1
			}
			
			else if (option == 5)
			{	
				System.out.println("Enter Account num (4 digit long): ");//Account number
				int num = user_input.nextInt();
				
				System.out.println("Enter date of establishment for the acc : ");//Date of establishment
				String date = user_input.next();
				
				System.out.println("Choose:" +nl+ "1. For assembly account"
						+nl+ "2. For process account" +nl+ "3. For dept account"+nl);// Choosing account type
				int ch = user_input.nextInt();
				int id;
				String id2;
				if (ch == 3)
				{
					System.out.println("Enter department number (3 digit long): ");//Dept. number entry
					id = user_input.nextInt();
					id2=null;
				}
				else
				{
					System.out.println("Enter Assembly/Process ID: ");//Assembly/Process number entry
					id = 0;
					id2=user_input.next();
				}
				System.out.println("Enter the cost: ");
				int cost = 	user_input.nextInt();	
				account_entry(num, date, ch, cost, id, id2);//Providing input to procedure for query 6
			}
			
			else if (option == 6)
			{
				System.out.println("Enter Job Number: ");//Account number
				int num = user_input.nextInt();
				
				System.out.println("Enter date of commencement for the job : ");//Date of establishment
				String date = user_input.next();
				
				System.out.println("Enter Assembly_ID for the Job:"+nl);// Choosing account id
				String a_id = user_input.next();
				
				System.out.println("Enter Process ID for the Job:"+nl);// Choosing process id
				String p_id = 	user_input.next();	
				job_entry(num, date, a_id, p_id);//Providing input to procedure for query 5
			}
			else if (option == 7)
			{
				System.out.println("Enter Job Number: ");//Account number
				int num = user_input.nextInt();
				
				System.out.println("Enter date of completion for the job : ");//Date of establishment
				String date = user_input.next();
				
				System.out.println("Enter labor time for the Job (hr:min:sec):"+nl);// Choosing account type
				String l_time = user_input.next();	
				
				System.out.println("Choose the Job type:"+nl+"1. Fit Job"
						+nl+ "2. Paint Job" +nl+ "3. Cut Job");// Choosing account type
				int ch = user_input.nextInt();
				
				if(ch == 1)
				{
					fit_job_completion(num, l_time, date);//Providing input to procedure for query 7 - fit job type
				}
				else if(ch == 2)
				{
					System.out.println("Enter color for the paint job : ");//color entry
					String col = user_input.next();
					
					System.out.println("Enter volume"+nl);// entering volume value
					int vol = user_input.nextInt();
					
					paint_job_completion(num,col,vol,l_time,date);//Providing input to procedure for query 7 - paint job type
				}
				else
				{
					System.out.println("Enter the type of machine used for the cut job : ");//type of machine entry
					String typ = user_input.next();
					
					System.out.println("Enter the material for the cut job : ");//material entry
					String mat = user_input.next();
					
					System.out.println("Enter amount of time machine was used for (hr:min:sec)");// entering volume value
					String a_time = user_input.next();
					
					cut_job_completion(num,typ,a_time,mat,l_time,date);//Providing input to procedure for query 7 - paint job type
				}
				
			}
			else if (option == 8) 
			{
				
				System.out.println("Enter Transaction number: ");//Transaction number entry
				int t_num = user_input.nextInt();
				
				System.out.println("Enter Job number for the requisite transaction: ");//Job number entry
				int j_num = user_input.nextInt();
				
				System.out.println("Enter the supplimentary cost for the transaction:");// Enter sup cost
				int s_cost = user_input.nextInt();
				
				updates_entry(t_num, s_cost, j_num);//Providing input to procedure for query 8
			
			}
			else if (option == 9)
			{
				System.out.println("Enter Assembly ID: ");//Transaction number entry
				String a_id = user_input.next();
				cost_assembly_retrieve(a_id);
			}
			else if (option == 10)
			{
				System.out.println("Enter the date: ");//Transaction number entry
				String date = user_input.next();
				System.out.println("Enter the department number: ");//Transaction number entry
				int d_num = user_input.nextInt();
				labor_time_retrieve(date,d_num);
				// yet for display to work
			}
			else if (option == 11)
			{
				System.out.println("Enter the assembly id: ");//Date entry
				String a_id = user_input.next();
				retrieve_process(a_id);
			}
			else if (option == 12)
			{
				System.out.println("Enter the date: ");//Date entry
				String date = user_input.next();
				System.out.println("Enter the department number: ");//Department number entry
				int d_num = user_input.nextInt();
				System.out.println("Choose the type of job: "
						+nl+"1. Fit job" +nl+ "2.Paint Job"
						+nl+ "3. Cut Job");			//Type of job entry
				int typ = user_input.nextInt();
				job_retrieve(date,d_num,typ);
			}
			else if (option == 13)
			{
				System.out.println("Enter start for the category range: ");// entry of start and end range of category
				int st = user_input.nextInt();
				System.out.println("Enter end for the category range: ");
				int end = user_input.nextInt();
				customer_retrieve(st,end);
			}
			else if (option == 14)
			{
				System.out.println("Enter start for the job no. range: ");// entry of start and end range of job no
				int st = user_input.nextInt();
				System.out.println("Enter end for the job no. range: ");
				int end = user_input.nextInt();
				cut_job_deletion(st,end);
			}
			else if (option == 15)
			{
				System.out.println("Enter the job no.");// entry of the job number and paint choice
				int j_num = user_input.nextInt();
				System.out.println("Enter color of the paint to be changed into ");
				String col = user_input.next();
				color_change(col,j_num);
				
			}
			else if (option == 16)
			{
				System.out.println("Enter the file name to import data");// entry of the job number and paint choice
				String file = user_input.next();				
				take_input(file);
				// C:/Users/akhil/eclipse-workspace/HW3/src/input.csv;
			}
			else if (option == 17)
			{
				System.out.println("Enter start for the category range: ");// entry of start and end range of category
				int st = user_input.nextInt();
				System.out.println("Enter end for the category range: ");
				int end = user_input.nextInt();
				export_customer(st,end);
				//export_data(int st, int end, String filename)
			}
			else if (option == 18)
			{
				System.out.println("You have chosen to Quit. Have a great day ahead");
				System.exit(0);//Breaking while loop
			}
			System.out.println("1. Enter Customer information" + nl + "2. Enter Department details" 
					+ nl + "3. Entry Assembly table" + nl + "4. Enter Process table" 
					+ nl + "5. Enter Account information" + nl+ "6. Enter Job Information (Assigned Table) "
					+ nl + "7. Enter Job Completion Data & Info"+nl + "8. Insert transaction info and update accounts"
					+nl+ "9. Retrieve cost for the assembly"+nl+ "10. Retrive total labor time for a given date"
					+nl+ "11. Retrieve the Process and related Department accessed by an assembly" 
					+nl+ "12. Retrieve a job information and the assembly id given a date and department"
					+nl+ "13. Retrieve customer information for a category range"
					+nl+ "14. Delete cut-jobs in a given job number range"
					+nl+ "15. Change the color of a paint job" 
					+nl+ "16. Import new customer details from data file"
					+nl+ "17. Export retrieved customer data in a category range"
					+nl+ "18. Quit");
		}
		
    }
}

	
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;


@Author("Kletzander Christian")
public class TestKletzi {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {

		//test1();
		//test2();
		
		List<Class> test = null;
		 try {
			 test = getClassesForPackage("");
		 } catch(Exception ex) {
			 ex.printStackTrace();
		 }
		
		System.out.println(test.toString());
		
	}
	
	private static void test1() {
		
		System.out.println("-------- Test #1 --------");
		
		Farm farmKletzi = new Farm("Kletzis Farm");		
		Tractor tr;
		
		tr = new Tractor<BioGas, Double>(100, new BioGas(), new Seeder(2));
		tr.incOperatingHours(12);
		tr.incConsumption(19.0);
		farmKletzi.addTractor(tr);
		
		tr = new Tractor<BioGas, Double>(101, new BioGas(), new Fertilizer(3));
		tr.incOperatingHours(15);
		tr.incConsumption(24.0);
		farmKletzi.addTractor(tr);
		
		tr = new Tractor<Diesel, Integer>(102, new Diesel(), new Seeder(8));
		tr.incOperatingHours(1);
		tr.incConsumption(5);
		farmKletzi.addTractor(tr);
		
		tr = new Tractor<Diesel, Integer>(103, new Diesel(), new Fertilizer(5));
		tr.incOperatingHours(7);
		tr.incConsumption(12);
		farmKletzi.addTractor(tr);
		
		tr = new Tractor<Diesel, Integer>(104, new Diesel(), new Fertilizer(9));
		tr.incOperatingHours(3);
		tr.incConsumption(29);
		farmKletzi.addTractor(tr);
		
		tr = new Tractor<BioGas, Double>(105, new BioGas(), new Seeder(9));
		tr.incOperatingHours(4);
		tr.incConsumption(4.0);
		farmKletzi.addTractor(tr);
		
		tr = new Tractor<Diesel, Integer>(106, new Diesel(), new Seeder(1));
		tr.incOperatingHours(10);
		tr.incConsumption(4);
		farmKletzi.addTractor(tr);
		
		System.out.println(farmKletzi);
		
		System.out.println("=> MinCoultsersPerFuel [AVG]");
		System.out.println(farmKletzi.minCoultersPerFuel());
		
		System.out.println("=> MaxCoultsersPerFuel [AVG]");
		System.out.println(farmKletzi.maxCoultersPerFuel());
	
		System.out.println("=> CapacityPerFuel [AVG]");
		System.out.println(farmKletzi.avgCapacityPerFuel());
		
		System.out.println("=> BioGasUsagePerRole [AVG]");
		System.out.println(farmKletzi.avgBioGasUsagePerRole());
	
		System.out.println("=> DieselUsagePerRole [AVG]");
		System.out.println(farmKletzi.avgDieselUsagePerRole());
		
		System.out.println("=> OperatingHoursPerFuel [AVG]");
		System.out.println(farmKletzi.avgOHPerFuel());
		
		System.out.println("=> OperatingHoursPerRole [AVG]");
		System.out.println(farmKletzi.avgOHPerRole());
		
	}
	
	private static void test2() {
		
		System.out.println("-------- Test #2 (Test von Null-Werten) --------");
		
		Farm farmKletzi = new Farm("Null Farm");		
		Tractor tr;
		
		tr = new Tractor<BioGas, Double>(100, new BioGas(), new Seeder(2));
		tr.incOperatingHours(11);
		tr.incConsumption(12.0);
		farmKletzi.addTractor(tr);
		
		tr = new Tractor<BioGas, Double>(101, new BioGas(), new Seeder(3));
		tr.incOperatingHours(11);
		tr.incConsumption(22.0);
		farmKletzi.addTractor(tr);
		
		tr = new Tractor<Diesel, Integer>(102, new Diesel(), new Fertilizer(8));
		tr.incOperatingHours(3);
		tr.incConsumption(8);
		farmKletzi.addTractor(tr);
		
		tr = new Tractor<Diesel, Integer>(103, new Diesel(), new Fertilizer(5));
		tr.incOperatingHours(2);
		tr.incConsumption(9);
		farmKletzi.addTractor(tr);
		
		tr = new Tractor<Diesel, Integer>(104, new Diesel(), new Fertilizer(9));
		tr.incOperatingHours(2);
		tr.incConsumption(13);
		farmKletzi.addTractor(tr);
		
		tr = new Tractor<BioGas, Double>(105, new BioGas(), new Seeder(9));
		tr.incOperatingHours(34);
		tr.incConsumption(44.0);
		farmKletzi.addTractor(tr);
		
		tr = new Tractor<Diesel, Integer>(106, new Diesel(), new Fertilizer(1));
		tr.incOperatingHours(10);
		tr.incConsumption(4);
		farmKletzi.addTractor(tr);
		
		System.out.println(farmKletzi);
		
		System.out.println("=> MinCoultsersPerFuel [AVG]");
		System.out.println(farmKletzi.minCoultersPerFuel());
		
		System.out.println("=> MaxCoultsersPerFuel [AVG]");
		System.out.println(farmKletzi.maxCoultersPerFuel());
	
		System.out.println("=> CapacityPerFuel [AVG]");
		System.out.println(farmKletzi.avgCapacityPerFuel());
		
		System.out.println("=> BioGasUsagePerRole [AVG]");
		System.out.println(farmKletzi.avgBioGasUsagePerRole());
	
		System.out.println("=> DieselUsagePerRole [AVG]");
		System.out.println(farmKletzi.avgDieselUsagePerRole());
		
		System.out.println("=> OperatingHoursPerFuel [AVG]");
		System.out.println(farmKletzi.avgOHPerFuel());
		
		System.out.println("=> OperatingHoursPerRole [AVG]");
		System.out.println(farmKletzi.avgOHPerRole());
		
	}
	
	/**
	 * Attempts to list all the classes in the specified package as determined
	 * by the context class loader
	 * 
	 * @param pckgname
	 *            the package name to search
	 * @return a list of classes that exist within that package
	 * @throws ClassNotFoundException
	 *             if something went wrong
	 */
	public static List<Class> getClassesForPackage(String pckgname) throws ClassNotFoundException {
		// This will hold a list of directories matching the pckgname. There may be more than one if a package is split over multiple jars/paths
		ArrayList<File> directories = new ArrayList<File>();
		try {
			ClassLoader cld = Thread.currentThread().getContextClassLoader();
			if (cld == null) {
				throw new ClassNotFoundException("Can't get class loader.");
			}
			String path = pckgname.replace('.', '/');
			// Ask for all resources for the path
			Enumeration<URL> resources = cld.getResources(path);
			while (resources.hasMoreElements()) {
				directories.add(new File(URLDecoder.decode(resources.nextElement().getPath(), "UTF-8")));
			}
		} catch (NullPointerException x) {
			throw new ClassNotFoundException(pckgname + " does not appear to be a valid package (Null pointer exception)");
		} catch (UnsupportedEncodingException encex) {
			throw new ClassNotFoundException(pckgname + " does not appear to be a valid package (Unsupported encoding)");
		} catch (IOException ioex) {
			throw new ClassNotFoundException("IOException was thrown when trying to get all resources for " + pckgname);
		}

		ArrayList<Class> classes = new ArrayList<Class>();
		// For every directory identified capture all the .class files
		for (File directory : directories) {
			if (directory.exists()) {
				// Get the list of the files contained in the package
				String[] files = directory.list();
				for (String file : files) {
					// we are only interested in .class files
					if (file.endsWith(".class")) {
						// removes the .class extension
						classes.add(Class.forName(pckgname + '.' + file.substring(0, file.length() - 6)));
					}
				}
			} else {
				throw new ClassNotFoundException(pckgname + " (" + directory.getPath() + ") does not appear to be a valid package");
			}
		}
		return classes;
	}
	
	
}

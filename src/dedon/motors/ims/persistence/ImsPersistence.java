package dedon.motors.ims.persistence;

import dedon.motors.ims.model.IMS;

public class ImsPersistence {
	
private static String filename = "data.ims";
	
	public static void save(IMS ims) {
		PersistenceObjectStream.serialize(ims);
	}
	
	public static IMS load() {
		PersistenceObjectStream.setFilename(filename);
		IMS ims = (IMS) PersistenceObjectStream.deserialize();
		// model cannot be loaded - create empty BTMS
		if (ims == null) {
			ims = new IMS();
		}
		else {
			ims.reinitialize();
		}
		return ims;
	}
	
	public static void setFilename(String newFilename) {
		filename = newFilename;
	}

}

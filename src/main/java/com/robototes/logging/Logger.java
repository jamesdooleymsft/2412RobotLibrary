package com.robototes.logging;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.Timer;

/**
 * The logger class, in charge of logging data to files during matches and
 * testing
 *
 * @author Eli Orona
 *
 */
public class Logger {

	private File m_logFile;
	private FileOutputStream m_outputStream;

	private LogType m_minLogType;

	private static Logger m_instance = null;
	private static boolean m_initialized = false;

	private Logger(String fileName, LogType minLogType) {
		m_minLogType = minLogType;
		m_logFile = new File(Filesystem.getDeployDirectory().getAbsolutePath() + fileName);
		try {
			m_logFile.createNewFile();
			m_outputStream = new FileOutputStream(m_logFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Initalizes the logger
	 *
	 * @param fileName   The file to log data to
	 * @param minLogType The minimum level for logging
	 */
	public static void initialize(String fileName, LogType minLogType) {
		if (m_initialized) {
			return;
		}

		m_instance = new Logger(fileName, minLogType);
		m_initialized = true;
	}

	/**
	 * Logs the data if the type is valid to the file
	 *
	 * @param data The data to log
	 * @param type The type of the log
	 */
	public void logData(String data, LogType type) {
		if (type.getLogLevel() <= m_minLogType.getLogLevel()) {
			return;
		}

		try {
			m_outputStream.write((Timer.getFPGATimestamp() + ",").getBytes());
			m_outputStream.write((type.name() + ",").getBytes());
			m_outputStream.write(data.getBytes());
		} catch (Exception e) {
		}
	}

	/**
	 * Gets the instance of the Logger
	 *
	 * @return Logger instance
	 */
	public static Logger getInstance() {
		return m_instance;
	}

}

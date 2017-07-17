
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// extends JFrame implements ActionListener
public class FileMonitor extends JFrame implements ActionListener {

	JTextArea jta = new JTextArea(5, 3);
	JScrollPane jsp = new JScrollPane(jta);
	JButton jb = new JButton("FileRefresh1");
	JButton jb2 = new JButton("FileRefresh2");
	JPanel jp = new JPanel();
	private static Vector<File> fl = new Vector<File>();

	public static void AllFiles(String dirs) throws Exception {
		File dir = new File(dirs);
		File[] fs = dir.listFiles();
		for (int i = 0; i < fs.length; i++) {
			if (!fs[i].isDirectory()) {
				int pos = fs[i].getName().lastIndexOf('.');
				if (pos == -1) {
					fl.add(new File(fs[i].getAbsolutePath()));
				}
			}
		}
	}

	FileMonitor() throws Exception {
		setTitle("FileMonitor");
		jb.addActionListener(this);
		jb2.addActionListener(this);
		jp.add(jb);
		jp.add(jb2);
		add(jsp, BorderLayout.CENTER);
		add(jp, BorderLayout.SOUTH);
		setSize(620, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) throws Exception {
		new FileMonitor();
		System.out.println("sss");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == jb) {
			try {
				final long timeInterval = 1000;
				Runnable runnable = new Runnable() {
					public void run() {
						while (true) {
							// ------- code for task to run
							jta.setText("");
							try {
								AllFiles("/Users/ecohnoch/Desktop/Server");
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							for (File file : fl) {
								readFile(file.getAbsolutePath());

							}
							fl.clear();
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							// ------- ends here
							try {
								Thread.sleep(timeInterval);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				};
				Thread thread = new Thread(runnable);
				thread.start();
				// System.out.println("xx");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == jb2) {
			try {
				final long timeInterval = 1000;
				Runnable runnable = new Runnable() {
					public void run() {
						while (true) {
							// ------- code for task to run
							jta.setText("");
							try {
								AllFiles("/Users/ecohnoch/Desktop/Server");
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							for (File file : fl) {
								readFile(file.getAbsolutePath());

							}
							fl.clear();
							try {
								Thread.sleep(3000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							// ------- ends here
							try {
								Thread.sleep(timeInterval);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				};
				Thread thread = new Thread(runnable);
				thread.start();
				// System.out.println("xx");
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}

	public void readFile(String filename) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			String str;
			while ((str = br.readLine()) != null) {
				jta.append(str + "\n");
			}
			jta.append("\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

# RoQME Installation

## Pre-Installation 

1.	Download the SmartSoft virtual machine from: https://wiki.servicerobotik-ulm.de/virtual-machine

2.	Import and run the virtual machine using, e.g., Virtualbox (https://www.virtualbox.org/).

    **IMPORTANT: All the instructions included next must be executed on the SmartMDSD virtual machine** 

3.	Enable “copy & paste” and “drag & drop” between your host OS and the virtual OS:
    1.	Devices -> Insert Guest Additions CD Image 
    1.	Devices -> Share Clipboard -> Bidirectional
    1.	Devices -> Drag and Drop -> Bidirectional
    1.	Restart the virtual machine to get the “Guest additions” running
    
4.	Download OpenSliceDDS Community Edition from: https://github.com/ADLINK-IST/opensplice/releases  

    ![](https://github.com/roqme/robmosys-itp/blob/master/docs/img/VersionDDS.png)

5.	Create a new folder "OpenSpliceDDS" into "/home/smartsoft" 

6.	Extract the file downloaded in (4) into the folder created in (5)

7.	Open the “release.com” file available at: "/home/smartsoft/OpenSpliceDDS/HDE/x86_64.linux/release.com"
    
    Original file
    ```
       1	if [ "${SPLICE_ORB:=}" = "" ]
       2	then
       3	SPLICE_ORB=DDS_OpenFusion_1_6_1
       4	export SPLICE_ORB
       5	fi
       6	if [ "${SPLICE_JDK:=}" = "" ]
       7	then
       8	SPLICE_JDK=jdk
       9	export SPLICE_JDK
      10	fi
      11	if [ -n "${BASH_VERSION}" ]
      12	then
      13	OSPL_HOME="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
      14	else
      15	echo "Please manually set OSPL_HOME to the install directory."
      16	fi
      17	PATH=$OSPL_HOME/bin:$PATH
      19	LD_LIBRARY_PATH=$OSPL_HOME/lib${LD_LIBRARY_PATH:+:}$LD_LIBRARY_PATH
      20	CPATH=$OSPL_HOME/include:$OSPL_HOME/include/sys:${CPATH:=}
      21	if [ "${OSPL_URI:=}" = "" ]
      22	then
      23	OSPL_URI=file://$OSPL_HOME/etc/config/ospl.xml
      24	export OSPL_URI
      25	fi
      26	OSPL_TMPL_PATH=$OSPL_HOME/etc/idlpp
      27	. $OSPL_HOME/etc/java/defs.$SPLICE_JDK
      28	export OSPL_HOME PATH LD_LIBRARY_PATH CPATH OSPL_TMPL_PATH VORTEX_DIR
    ```
8.	Add line 17 as follows:
    
    Edited file
    ```
        1	    if [ "${SPLICE_ORB:=}" = "" ]
        2	    then
        3	    SPLICE_ORB=DDS_OpenFusion_1_6_1
        4	    export SPLICE_ORB
        5	    fi
        6	    if [ "${SPLICE_JDK:=}" = "" ]
        7	    then
        8	    SPLICE_JDK=jdk
        9	    export SPLICE_JDK
       10	fi
       11	if [ -n "${BASH_VERSION}" ]
       12	then
       13	OSPL_HOME="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
       14	else
       15	echo "Please manually set OSPL_HOME to the install directory."
       16	fi
    >> 17	OSPL_HOME="/home/smartsoft/OpenSpliceDDS/HDE/x86_64.linux"
       18	PATH=$OSPL_HOME/bin:$PATH
       19	LD_LIBRARY_PATH=$OSPL_HOME/lib${LD_LIBRARY_PATH:+:}$LD_LIBRARY_PATH
       20	CPATH=$OSPL_HOME/include:$OSPL_HOME/include/sys:${CPATH:=}
       21	if [ "${OSPL_URI:=}" = "" ]
       22	then
       23	OSPL_URI=file://$OSPL_HOME/etc/config/ospl.xml
       24	export OSPL_URI
       25	fi
       26	OSPL_TMPL_PATH=$OSPL_HOME/etc/idlpp
       27	. $OSPL_HOME/etc/java/defs.$SPLICE_JDK
       28	export OSPL_HOME PATH LD_LIBRARY_PATH CPATH OSPL_TMPL_PATH VORTEX_DIR
    ```
9.	Once edited, copy the contents of the previous file at the end of the .bashrc file available at: “/home/smartsoft”. Note that this file is hidden by default. To make hidden files visible press Ctrl-H.

10.	Open a terminal window and execute the following command to build the DDS library: 
    ```
    make -C $OSPL_HOME/custom_lib -f Makefile.Build_DCPS_ISO_Cpp2_Lib 
    ```
11.	Open a new terminal, move to the “home/smartsoft” directory, and execute the following command to clone the GitHub repository:
    ```
    git clone https://github.com/DOCGroup/MPC
    ```
12.	Open again the .bashrc file, available at: “/home/smartsoft”, and include the following line at the end:
    ```
    export MPC_ROOT="/home/smartsoft/MPC"
    ```
13.	Open a new terminal and execute the following command to create a new environment variable and update the .bashrc file:
    ```
    source .bashrc
    ```
14.	RoQME uses GTK versión 2. In order to move from GTK 3 to GTK 2, open the “eclipse.ini” file available at: “/home/smartsoft/SOFTWARE/SmartMDSD-Toolchain-v3.7/”:

    Original file
    ```    
        1	-startup
        2	plugins/org.eclipse.equinox.launcher_1.4.0.v20161219-1356.jar
        3	--launcher.library
        4	plugins/org.eclipse.equinox.launcher.gtk.linux.x86_64_1.1.551.v20171108-1834
        5	-product
        6	org.eclipse.epp.package.modeling.product
        7	-showsplash
        8	org.eclipse.epp.package.common
        9	--launcher.defaultAction
       10	openFile
       11	--launcher.appendVmargs
       12	-vm
       13	/usr/lib/jvm/java-8-openjdk-amd64/bin
       14	-vmargs
       15	-Dosgi.requiredJavaVersion=1.8
       16	-Dosgi.instance.area.default=@user.home/eclipse-workspace
       17	-XX:+UseG1GC
       18	-XX:+UseStringDeduplication
       19	--add-modules=ALL-SYSTEM
       20	-Dosgi.requiredJavaVersion=1.8
       21	-Xms256m
       22	-Xmx1024m
       23	--add-modules=ALL-SYSTEM
       24	-Declipse.p2.max.threads=10
       25	-Doomph.update.url=http://download.eclipse.org/oomph/updates/milestone/latest
       26	-Doomph.redirection.index.redirection=index:/->http://git.eclipse.org/c/oomph/org.eclipse.oomph.git/plain/setups/
    ```
15.	Copy lines 11 and 12 and save the file:

    Edited file
    ```
        1	-startup
        2	plugins/org.eclipse.equinox.launcher_1.4.0.v20161219-1356.jar
        3	--launcher.library
        4	plugins/org.eclipse.equinox.launcher.gtk.linux.x86_64_1.1.551.v20171108-1834
        5	-product
        6	org.eclipse.epp.package.modeling.product
        7	-showsplash
        8	org.eclipse.epp.package.common
        9	--launcher.defaultAction
       10	openFile
    >> 11	--launcher.GTK_version
    >> 12	2
       13	--launcher.appendVmargs
       14	-vm
       15	/usr/lib/jvm/java-8-openjdk-amd64/bin
       16	-vmargs
       17	-Dosgi.requiredJavaVersion=1.8
       18	-Dosgi.instance.area.default=@user.home/eclipse-workspace
       19	-XX:+UseG1GC
       20	-XX:+UseStringDeduplication
       21	--add-modules=ALL-SYSTEM
       22	-Dosgi.requiredJavaVersion=1.8
       23	-Xms256m
       24	-Xmx1024m
       25	--add-modules=ALL-SYSTEM
       26	-Declipse.p2.max.threads=10
       27	-Doomph.update.url=http://download.eclipse.org/oomph/updates/milestone/latest
       28	-Doomph.redirection.index.redirection=index:/->http://git.eclipse.org/c/oomph/org.eclipse.oomph.git/plain/setups/
    ```

16.	Installation of the RoQME Plugin:

    1.	Download the RoQME plugin (RoQME-Eclipse-Tools-vXXXX) from: 
    
        https://github.com/roqme/robmosys-itp/blob/master/downloads/
    
    1.	Create a new “RoQME” folder at “/home/smartsoft” and extract the file previously downloaded in (i)
    
    1.	Launch Eclipse and install the RoQME plugin in Eclipse, by selecting the following menu options:
       
         **_Help - > Install New Software… - > Add… - > Local… - > {Repository path}_**
       
    1.	Restart Eclipse
 
## Using RoQME within SmartMDSD:

1.	Creating a new RoQME Project:

    1.	**_File - > New - > Other -> RoQME Project_**
    
    1.	Choose the project name and click the **_Next_** button
    
    1.	Click on **_Load Repository_** and choose the required contexts. For instance, to include the information provided by the bumper as a context, choose the _CommBasicsObjects.BumperEventService_ service, available at: “/home/smartsoft/SOFTWARE/smartsoft/repos/DomainModelsRepositories/CommBasicsObjects/model/CommBasicObjects.service” 
    
    1.	Browse the services in the tree model until you find the bumper and select: _CommBasicsObjects.BumperEventService: new State[Enum]_
    
    1.	Once selected, press the **_Add context_** button
    
    1.	Double click on the name of the context and change it from _context0_ to _bump_
    
    1.	Repeat steps iii – vi for each context that needs to be included as an input in the RoQME model
    
    1.	Click the **_Finish_** button
    
    **IMPORTANT**: New RoQME Projects include two files: (1) a **_.roqme model_**, including the definitions of the contexts relevant for the current project; and (2) a **_.roqmemap_** model that binds the previous contexts with the corresponding Smartsoft services (this mapping is created during the project configuration: steps iii – vi). 
    
2.	Extending the .roqme model. Once initialized as described in step 1, the RoQME model can be extended to include relevant (non-functional) properties, observations, variables, etc. Next, you can find an example .roqme model including:

    1.	Three contexts: _bump_, which is a primitive context (the one directly provided by the corresponding Smartsoft service according to the mapping created in step 1.vi); and _bumpEvent_ and _bumpCount_, which are two additional contexts derived from _bump_. **IMPORTANT**: adding new primitive contexts requires appropriately updating the corresponding .roqmemap model!!
    
    1.	The _safety_ property that takes a default value of 1; and
    
    1.	Two observations: _o1_ => safety is undermined every time a bumpEvent is detected; and _o2_ => safety is (veryhigh) undermined if more than 5 bumpEvents are detected within 1 hour.
    
   ```
         roqme RoQME_Example

         context bump : enum {BUMPER_UNKNOWN, BUMPER_NOT_PRESSED, BUMPER_PRESSED}
         context bumpEvent : eventtype := bump::BUMPER_PRESSED
         context bumpCount : number := count(bumpEvent,1hour)

         property safety reference 1

         timer t := 1 hour
         observation o1 : bumpEvent undermines safety
         observation o2 : t while (bumpCount >5) undermines safety veryhigh
   ```

3.	Generating the RoQME QoS metric provider component model. 

    In order to generate the RoQME artifacts from the previous models, right click on the .roqmemap file and select:
    
    **_RoQME - > Generate Metrics Provider_** 
    
    This generation process will create two projects: (1) a **_QoSMetricProvider project_**; and (2) **_CommRoqmeEstimate project_**. The former includes the generated Smartsoft component model for the QoS Metric Provider. Smartsoft will use this model as an input to generate the corresponding software. The latter includes the definition of the communication objects used by the QoS metric provider component to communicate the estimated metrics to other components. 

    The following figure illustrates the structure of the generated Smartsoft component model, including (1) the inputs obtained from the external context providers (red square); (2) the three main processes carried out by the component (i.e., context monitoring, event processing, and probabilistic reasoning) connected through the so called RoQME Data Space (blue square); and (3) the structure of the communication objects used to provide the metrics to other components (green square).
![](https://github.com/roqme/robmosys-itp/blob/master/docs/img/Smartsoft.PNG)
 
4.	Compiling the generated C/C++ code.

	Both the RoQME Data Space (based on DDS) and the probabilistic reasoner are implemented in C/C++ and, thus, need to be compiled following the steps indicated next:

* Copy the following code at the end of the .bashrc file, available at: “/home/smartsoft”, in order to create the ROQME_ROOT, LD_LIBRARY_PATH and CPATH environment variables: 

        ```
        export ROQME_ROOT="/home/smartsoft/workspaces/SmartMDSD-Toolchain/QoSMetricProvider/roqme-dds/cpp"
        export LD_LIBRARY_PATH=$ROQME_ROOT/roqmeDDS/lib:$LD_LIBRARY_PATH
        export CPATH=$ROQME_ROOT/roqmeDDS/include:$ROQME_ROOT/roqmeDDS/idl:$CPATH
        ```   

	**FOR THE DDS Library**

	* Move to the generated “roqme-dds” project, available at: “/home/smartsoft/workspaces/SmartMDSD-Toolchain/QoSMetricProvider/roqme-dds/cpp/roqmeDDS”, open a new terminal and execute the following commands: 

	```
	chmod +777 gen_makefile.sh
	./gen_makefile.sh
	make
	```

	**FOR THE Probabilistic Reasoner**

	* Move to the generated “reasoner” project, available at: “/home/smartsoft/workspaces/SmartMDSD-Toolchain/QoSMetricProvider/reasoner”, open a new terminal and execute the following commands: 

	```
	chmod +777 gen_makefile.sh
	./gen_makefile.sh
	make
	```

Et voilá! The generated RoQME component can now be used within any Smartsoft architecture as a QoS metrics provider.

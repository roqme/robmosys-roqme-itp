
# RoQME Installation

# Pre-Installation 

1.	Download the SmartMDSD virtual machine 
https://wiki.servicerobotik-ulm.de/virtual-machine
2.	Import and run the virtual machine using, e.g., Virtualbox 
https://www.virtualbox.org/
IMPORTANT: All the instructions included next must be executed on the SmartMDSD virtual machine
3.	Enable “copy & paste” and “drag & drop” between your host OS and virtual OS:
3.1	Devices -> Insert Guest Additions CD Image 
3.2	Devices -> Share Clipboard -> Bidirectional
3.3	Devices -> Drag and Drop -> Bidirectional
3.4	Restart the virtual machine to get the “Guest additions” running
4.	Download OpenSliceDDS Community Edition: 
https://github.com/ADLINK-IST/opensplice/releases  
5.	Create a new folder “OpenSpliceDDS” into “/home/smartsoft” 
6.	Extract the file downloaded in (4) into the folder created in (5)
7.	Open the “release.com” file available at: /home/smartsoft/OpenSpliceDDS/HDE/x86_64.linux/release.com
    
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
    16	Fi
    17	
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
8.	Add the line 17 (highlighted in red) as follows:
    
    Edited file
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
    ```
    17	**OSPL_HOME="/home/smartsoft/OpenSpliceDDS/HDE/x86_64.linux"**
    ```
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

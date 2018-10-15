# TIBCO PSG 2018 | API Platform &amp; API-led Integration

As part of this breakout, some exercises are planned, this guide is to help setting up the environment.

## Preparing for running the labs

Software you need to install or accounts you need to have to be able to carry on the labs during the workshops.

## Operating System
You should be able to run the labs if you are running on the following OS choices

* macOS
* Windows 10
  * **Make sure to enable hardware virtualisation in BIOS**
* Linux e.g. CentOS or Ubuntu

## Accounts

These accounts are needed to run through the labs:

* TIBCO Cloud
  * TIBCO Cloud Mashery
  * TIBCO Cloud Integration
  
  
items

labs 
lab 1 instructions
lab 1 artefacts
lab 2 instructions
lab 2 artefacts 

pre-requisites 
the labs are designed to use TIBCO Cloud Mashery, the following capabilities are expected to be used 
TIBCO Cloud Mashery Control Center
TIBCO Cloud Mashery API Modeling
TIBCO Cloud Integration, BW
TIBCO Cloud Integration, Mock up

software to install prior to the event 

instructions for both Windows 10 and macOS 

virtualbox, vmware station or vmware fusion
instructions for virtualbox 

Windows 10

macOS 

text editor of choice 
the instructor will be using Microsoft vscode 

Windows 10 

macOS

http client 
several options
curl - if you have good experience with 
httpie - terminal friendly
postman - most common
Paw cloud 

postman install instructions 

Windows 10 

macOS 


## Accounts

These accounts are needed to run through the labs:

* AWS
  * You will get assigned credentials by your instructor to access AWS to execute the relevant labs
  * AWS Username, AccessKeyId, SecretAccessKey

* Docker ID for Docker Hub
  * Create a Docker Hub account if you don't have one https://hub.docker.com/
  * Note your docker id and password
  * After you get Docker installed, log in to your Docker Hub

![Screenshot](https://github.com/mshahat/interconnect_barcelona2017/blob/master/graphics/Screen%20Shot%202017-10-11%20at%2018.53.55.png)

* TIBCO Cloud Integration
  * Sign up for trial EMEA - https://eu.account.cloud.tibco.com/signup/tci
  * Sign up for trial Americas - https://account.cloud.tibco.com/signup/tci
  * Sign up for trial Australia - https://au.account.cloud.tibco.com/signup/tci
  * If you have an expired trial - Google Hangout me for the form to request extension



## Software

### TIBCO

Download TIBCO installers from https://edelivery.tibco.com 

install the following software on your machine. ( if you prefer to use a vm to leave your machine neat, make yourself at home ! )

* optional - BW5.13 including RV, TRA
* BWCE 2.3.1
* TCI Studio 1.0.5
* TCI CLI - follow install instructions https://integration.cloud.tibco.com/docs/getstarted/installation/installing-cli.html
* FTL 5.2.1
* optional - EMS 8.4 ( this is needed for jms libs, we're providing the libs, so no need to install if you don't need to )

### Thirdparty

For Linux users use your package manager for most of these, or follow the links provided below.
For macOS users homebrew is a decent option to install thirdparty software https://brew.sh/

I'm including the homebrew commands to download some sofware for those on macOS

If you fancy using a **vagrant box** which provides some of these components, [GO HERE](https://github.com/mshahat/interconnect_barcelona2017#option-b---vagrant-box)

* Text Editor, I use VS Code. TextMate, Notepad++ ...etc.
* Microsoft Powerpoint - to go through the labs instructions
* Docker CE 17.x, Docker for mac, Docker for Windows - https://www.docker.com/community-edition
* optional - Kitematic - to browse Docker Hub images - https://github.com/docker/kitematic/releases
* Java 1.8 or else
* Putty - for windows users
* Winscp - for windows users

#### Option A - local installs
install the following to your machine

* AWS cli - install from https://aws.amazon.com/cli/
  ```console
  brew update && brew install awscli
  ```
* kubectl - kubernetes cli - https://kubernetes.io/docs/tasks/tools/install-kubectl/
  ```console
  brew update && brew install kubectl
  ```
* kops - kubernetes operations
  ```console
  brew update && brew install kops
  ```
#### Option B - Vagrant box
use vagrant box to have the following preinstalled

* AWS cli
* kubectl
* kops

To use vagrant, please install:

* Virtualbox - https://www.virtualbox.org/wiki/Downloads (5.1.28)
  ```console
  brew cask install virtualbox
  ```
* Vagrant - https://www.vagrantup.com/downloads.html
  ```console
  brew cask install vagrant
  ```
  * if you're using vagrant, you might find it useful to copy stuff from your local machine to vagrant box
  ```console
  vagrant scp /path/to/local.file vagrant-machine-name:/path/to/vagrant/box.file
  ```
* optional - a nice vagrant manager UI on macOS
  ```console
  brew cask install vagrant-manager
  ```
![Screenshot](https://github.com/mshahat/interconnect_barcelona2017/blob/master/graphics/Screen%20Shot%202017-10-11%20at%2022.47.18.png)
To get the vagrant box please do the following 
 1. create a directory, name it for e.g. psg_barcelona
 2. cd to the directory, init the vagrant box 
 ```console
 vagrant init onlyfreeaccess/BWCE
 ```
 
 3. Setup provider env var (on UNIX-like systems use):
  ```console
  export VAGRANT_DEFAULT_PROVIDER=virtualbox
  ```

 4. run this command to start the vagrant box ( **You have to be inside the directory e.g. psg_barcelona** )
 ```console
 vagrant up
 ```


---
## Labs
The following activites need to take place to be able to run the labs 

### Lab1
In this lab you should end up with a BWCE app. You need to generate BWCE base image, as well as include ems libraries. You can use the following images if you need to

* BWCE 2.3.1 base image
  ```console
  docker pull mshahat/bwce:2.3.1
  ```
* BWCE 2.3.1 base image + EMS libs
  ```console
  docker pull mshahat/bwce:2.3.1.ems
  ```
* BWCE 2.3.1 app 
  ```console
  docker pull mshahat/bw5tobwce:1.0
  ```

### Lab2
For this lab you need to generate a key pair
 1. Go to https://console.aws.amazon.com/console/home
 2. Use account ID in Lab2 instructions
 3. Use username and password assigned by your instructor --> "username"Tibco123
 4. Once logged in, go to **All Services** -> **Compute** -> **EC2**
 5. On the left bar under **Network & Security** , go to **Key Pairs**
 6. **Create Key Pair** -> **Key Pair Name**: "username"-keypair ... This will download a .pem file to your machine which is your private key
 7. Use this to generate a public key 
 
 #### Windows
 Use Putty key generator to generate your public key
  1. Load private key 
  2. click on Generate
  3. copy and paste into a file, save as .pub file
 
 #### macOS
use ssh-keygen to generate your public key
before you do , please make sure to change file permissions 
  ```console
  chmod 400 /path/to/your/keypair.pem
  ```
  then

  ```console
  ssh-keygen -y -f /path/to/your/keypair.pem > /path/to/save/your/public/key/key.pub
  ```
  
  8. Copy AWS private and public key files to the vagrant box. The easiest way to transfer files from the host to the VM is to just put them in the same directory as the Vagrantfile (psg_brcelona) - that directory is automatically mounted under /vagrant in the VM so you can copy or use them directly from the VM."
 
 9. SSH into the vagrant box
 ```console
  vagrant ssh
  ```
 10. Copy Public and Private Keys from /vagrant to ~/.ssh on vagrant box
 
 11. Logout
 ```console
  vagrant logout
  ```

 


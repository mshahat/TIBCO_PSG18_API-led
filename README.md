# TIBCO PSG 2018 | API Platform &amp; API-led Integration

As part of this breakout, some exercises are planned, this guide is to help setting up the environment and list labs and artefacts.

### Please file github ISSUE for any questions 

## Labs
The following labs are planned, click on each for more details

 * [Events Processing Lab 1](https://github.com/mshahat/TIBCO_PSG18_API-led/tree/master/labs/event-processing-lab1)
 * Events Processing Lab 2
 * [API-led Lab 1](https://github.com/mshahat/TIBCO_PSG18_API-led/tree/master/labs/api-lab1)
 * [API-led Lab 2](https://github.com/mshahat/TIBCO_PSG18_API-led/tree/master/labs/api-lab2)

## Prerequisites
Software you need to install and accounts you need to have to be able to carry on the labs during the workshops.

## Operating System
You should be able to run the labs on your OS of choice

* macOS
* Windows 10
  * **Make sure to enable hardware virtualisation in BIOS**
* Linux e.g. CentOS or Ubuntu

## Accounts
These accounts are needed to run through the labs:
* TIBCO Cloud
  * TIBCO Cloud Mashery
  * TIBCO Cloud Integration
* Invitations to TIBCO Cloud to be received directly over @tibco.com emails
* Sign into https://cloud.tibco.com/ , choose the _PSG Event 2018 API-led_ organisation

Expected to use the following capabilities 
* TIBCO Cloud Mashery Control Center
* TIBCO Cloud Mashery API Modeling
* TIBCO Cloud Integration, BW
* TIBCO Cloud Integration, Mock up

## Software for Events Processing Labs
Choose one of two options to run the Events Processing labs

1. An Ubuntu vm with software required ( recommended )
Download an Ubuntu linux vm for the EventProcessing Labs [HERE](https://drive.google.com/open?id=1guqTkECGv5FU5wUCEzGSX6KOq0OJDgpu)

* You will need to be signed in using TIBCO Google Account
* README available on desktop
* The vm is split into 8 parts .001 to .008
* Unarchive to a folder of choice using ["7zip"](https://www.7-zip.org/) on Windows or ["Keka"](https://www.keka.io/en/) on macOS 
* The vm by default is allocated 1 vCPU and 4GB RAM
* Run the VM using Virtualbox ( instructions to install below )
* Use `sudo` for privilegded actions
* Use user `tibco` with `tibco123` to login

2. download & install the following software on your laptop 
* TIBCO BusinessEvents Enterprise Edition 5.5
* [Apache kafka_2.11-1.0.2](https://archive.apache.org/dist/kafka/1.0.2/kafka_2.11-1.0.2.tgz)
* if you choose to install the software on your machine, we suggest you use the following path if you're on Linux or macOS
`/opt/tibco/cep/be/5.5`
`/opt/kafka_2.11-1.0.2`
`/opt/projects`


## Software for API-led labs 
Please choose to download and install each requirement. 
Instructions for using a package manager is included. 
* macOS, https://brew.sh/
* Windows 10, https://chocolatey.org/  use Powershell

### software
* Text editor e.g. Microsoft VSCode https://code.visualstudio.com/
* Virtualbox > 5.2.18 , to run a vm for the Events Processing lab https://www.virtualbox.org/
* An HTTP client, to test APIs
  * Postman - GUI (free)      https://www.getpostman.com/
  * Httpie - CLI  (free)      https://httpie.org/
  * Paw Cloud     (for a fee) https://paw.cloud/
* Docker
  * Make sure to pull this before arriving to the venue
```shell
docker pull mysql
```

### I. Text Editor 
Feel free to use the text editor of choice. 

_macOS_
```
brew cask install visual-studio-code
```
_Windows 10_
```
C:\> choco install vscode
```

### II. Virtualbox 
For those using vmware fusion or workstation, you could try to import the vm without the need for virtualbox 

_macOS_
```
brew cask install virtualbox
```
_Windows 10_
```
C:\> choco install virtualbox
```

### III. Http client

#### Postman 
_macOS_
```
brew cask install postman
```
_Windows 10_
```
C:\> choco install postman
```

#### Httpie
_macOS_
```
brew install httpie
```
_Windows 10_
```

```
### IV. Docker
_macOS_
https://store.docker.com/editions/community/docker-ce-desktop-mac 

_Windows 10_
https://store.docker.com/editions/community/docker-ce-desktop-windows


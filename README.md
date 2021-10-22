# Easy-Scheduler-AlarmApp-System

This is a scheduling app that  enables a user to schedule a call, message, link and alarms. It automates these activities.

## Table of Contents

- [Easy-Scheduler-AlarmApp-System](#easy-scheduler-alarmapp-system)
  - [Table of Contents](#table-of-contents)
  - [Problem Statement](#problem-statement)
  - [Objectives](#objectives)
  - [Users](#users)
  - [Technologies](#technologies)
  - [Contributing Guide](#contributing-guide)
  - [Requirement Specification](#requirement-specification)
    - [Technical requirements](#technical-requirements)
    - [Non-Functional Requirements](#non-functional-requirements)
    - [Functional Requirements](#functional-requirements)
      - [Message scheduler](#message-scheduler)
      - [Call scheduler](#call-scheduler)
      - [Link scheduler](#link-scheduler)
      - [Alarm](#alarm)
  - [Software Design Description](#software-design-description)
    - [User Design Interface](#user-design-interface)
    - [Home landing interface](#home-landing-interface)

## Problem Statement

Ideally, people who have busy schedule or tend to forget things easily should have a way on how they can schedule activities such as making phone calls, sending messages, opening links and setting alarms to be fired in the future. Currently, people use reminders to remind them that they have to do certain activities. Some uses scheduling apps from play store or third-party apps for scheduling messages and calls. These apps, some require a fee to be paid in order to work, others are free and not to mention that they are just individual apps, they will require space to install. This project proposes creation of mobile based app that has all these features integrated in a single app making it to be more like a system.

## Objectives

The main objective of this project is to develop an android based alarm system that has the capabilities of scheduling or automating calls, messages and opening of links at specified time.
This can be broken down into:

1. To develop an alarm module that enable users to set normal alarms for daily use. For example, waking up alarms.
2. To develop a link scheduler module that enables users to set links to open in the future.
3. To develop a message scheduler module that   enables users to schedule messages so as to be sent in the future.
4. To develop a call scheduler module that enables users to schedule calls so as to call someone in the future.

## Users

- Students
- Teachers
- Secretaries
- Accountants
- Delivery guys

## Technologies

The system will use the following technologies

- Java for Android
- SQLite

## Contributing Guide

1. Fork this repository to your account.
2. Clone the repository to your local machine.
3. Create a branch with the name of the feature you want to add or an issue you want to fix.
4. Add the feature and push to GitHub.
5. Create a pull request with the developer branch.

## Requirement Specification

### Technical requirements

- Android phone running at least android version  4.0 and above
- Android Studio Software
- i3 or AMD CPU supporting windows Hypervisor
- 64-bit Microsoft Windows 10
- Minimum 4GB RAM
- Free Storage of at least 10GB

### Non-Functional Requirements

- The system should be simple and light weight for ease access
- Should be responsive to different screen sizes

### Functional Requirements

#### Message scheduler

This module consists of the following functional requirements.

- It should be able to enable a user to write and send messages. It should have the capabilities of accessing the default messaging app in order to send the messages.
- Should provide a button to schedule the message to be sent in the future.
- Should be able to provide proper alert once the process is completed like a Toast notification.
- Should be able to save message history in SQLite database of the default messaging app. Such that when a message is sent it appears among the threads of the default messaging app.
- Prompt to grant appropriate permissions like accessing contacts, reading phone states, sending of messages etc.

#### Call scheduler

This module consists of the following functional requirements.

- It should enable the user to make a call. It should have the capabilities of accessing the default call app.
- It should be able to schedule a call so as to fire in the future.
- Should be able to dial a phone call and provide proper alert once a call is scheduled.

#### Link scheduler

- This module consists of the following functionalities.
- It should enable the user to enter a desired link to be scheduled.
- It should be able to open the link with the default link handler app, default browser set by the user.
- It should be able to read the phone states and provide an alert once a process is completed.

#### Alarm

The alarm module consists of the following functionalities.

- It should enable the user to set a normal alarm for waking up or other activities.
- should be able to cancel an alarm.
- It should be able to read the phone state like date and time of the device

## Software Design Description

### User Design Interface

### Home landing interface

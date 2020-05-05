CREATE DATABASE `evs` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `evs`;

#
# Source for table "evs_tbl_election"
#

CREATE TABLE `evs_tbl_election` (
  `electionid` int(11) NOT NULL DEFAULT '0',
  `name` varchar(15) NOT NULL DEFAULT '',
  `district` varchar(15) NOT NULL DEFAULT '',
  `constituency` varchar(15) NOT NULL DEFAULT '',
  `countingdate` date DEFAULT '0000-00-00',
  `electiondate` date DEFAULT '0000-00-00',
  PRIMARY KEY (`electionid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Source for table "evs_tbl_eo"
#

CREATE TABLE `evs_tbl_eo` (
  `electoralofficerid` int(11) NOT NULL DEFAULT '0',
  `constituency` varchar(25) NOT NULL DEFAULT '',
  PRIMARY KEY (`electoralofficerid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Source for table "evs_tbl_party"
#

CREATE TABLE `evs_tbl_party` (
  `partyid` int(6) NOT NULL DEFAULT '0',
  `name` varchar(20) NOT NULL DEFAULT '',
  `leader` varchar(20) NOT NULL DEFAULT '',
  `symbol` varchar(40) NOT NULL DEFAULT '',
  `electionid` int(6) NOT NULL DEFAULT '0',
  PRIMARY KEY (`partyid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Source for table "evs_tbl_result"
#

CREATE TABLE `evs_tbl_result` (
  `serialno` int(6) NOT NULL DEFAULT '0',
  `electionid` int(11) NOT NULL DEFAULT '0',
  `candidateid` int(11) NOT NULL DEFAULT '0',
  `votecount` int(5) unsigned DEFAULT NULL,
  `resultstatus` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`serialno`),
  KEY `evs_tbl_result_fk` (`candidateid`),
  KEY `evs_tbl_result_fk_1` (`electionid`),
  CONSTRAINT `evs_tbl_result_fk` FOREIGN KEY (`electionid`) REFERENCES `evs_tbl_eo` (`electoralofficerid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Source for table "evs_tbl_user_credentials"
#

CREATE TABLE `evs_tbl_user_credentials` (
  `userid` int(11) NOT NULL DEFAULT '0',
  `password` varchar(20) NOT NULL DEFAULT '',
  `usertype` varchar(1) NOT NULL DEFAULT '',
  `loginstatus` int(1) unsigned DEFAULT NULL,
  `sessionid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Source for table "evs_tbl_application"
#

CREATE TABLE `evs_tbl_application` (
  `userid` int(11) NOT NULL DEFAULT '0',
  `constituency` varchar(20) NOT NULL DEFAULT '',
  `passedstatus` int(2) unsigned NOT NULL DEFAULT '0',
  `approvedstatus` int(2) unsigned NOT NULL DEFAULT '0',
  `voterid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`userid`),
  CONSTRAINT `evs_tbl_application_fk` FOREIGN KEY (`userid`) REFERENCES `evs_tbl_user_credentials` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Source for table "evs_tbl_user_profile"
#

CREATE TABLE `evs_tbl_user_profile` (
  `userid` int(11) NOT NULL DEFAULT '0',
  `firstname` varchar(15) NOT NULL DEFAULT '',
  `lastname` varchar(15) DEFAULT '',
  `dateofbirth` date DEFAULT NULL,
  `gender` varchar(7) NOT NULL DEFAULT '',
  `street` varchar(30) NOT NULL DEFAULT '',
  `location` varchar(15) NOT NULL DEFAULT '',
  `city` varchar(15) NOT NULL DEFAULT '',
  `state` varchar(15) NOT NULL DEFAULT '',
  `pincode` varchar(10) NOT NULL DEFAULT '',
  `mobileno` varchar(10) NOT NULL DEFAULT '',
  `emailid` varchar(30) NOT NULL DEFAULT '',
  `usertype` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`userid`),
  CONSTRAINT `evs_tbl_user_profile_fk` FOREIGN KEY (`userid`) REFERENCES `evs_tbl_user_credentials` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Source for table "evs_tbl_voter"
#

CREATE TABLE `evs_tbl_voter` (
  `userid` int(6) NOT NULL DEFAULT '0',
  `password` varchar(20) NOT NULL,
  `usertype` varchar(1) NOT NULL,
  `loginstatus` int(1) unsigned DEFAULT NULL,
  `firstname` varchar(15) NOT NULL,
  `lastname` varchar(15) DEFAULT NULL,
  `dateofbirth` date DEFAULT NULL,
  `gender` varchar(7) NOT NULL,
  `street` varchar(30) NOT NULL,
  `location` varchar(15) NOT NULL,
  `city` varchar(15) NOT NULL,
  `state` varchar(15) NOT NULL,
  `pincode` varchar(10) NOT NULL,
  `mobileno` varchar(10) NOT NULL,
  `emailid` varchar(30) NOT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `userid` (`userid`),
  CONSTRAINT `evs_tbl_voter_fk_2` FOREIGN KEY (`userid`) REFERENCES `evs_tbl_application` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `evs_tbl_voter_fk` FOREIGN KEY (`userid`) REFERENCES `evs_tbl_user_credentials` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `evs_tbl_voter_fk_1` FOREIGN KEY (`userid`) REFERENCES `evs_tbl_user_profile` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Source for table "evs_tbl_voter_details"
#

CREATE TABLE `evs_tbl_voter_details` (
  `serialno` int(6) NOT NULL DEFAULT '0',
  `candidateid` int(11) NOT NULL DEFAULT '0',
  `electionid` int(11) NOT NULL DEFAULT '0',
  `voterid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`serialno`),
  KEY `evs_tbl_voter_details_fk` (`electionid`),
  KEY `evs_tbl_voter_details_fk_1` (`candidateid`),
  CONSTRAINT `evs_tbl_voter_details_fk` FOREIGN KEY (`electionid`) REFERENCES `evs_tbl_election` (`electionid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Source for table "evs_tbl_candidate"
#

CREATE TABLE `evs_tbl_candidate` (
  `candidateid` int(11) NOT NULL DEFAULT '0',
  `name` varchar(20) NOT NULL DEFAULT '',
  `electionid` int(11) NOT NULL DEFAULT '0',
  `partyid` int(11) NOT NULL DEFAULT '0',
  `district` varchar(20) NOT NULL DEFAULT '',
  `constituency` varchar(20) NOT NULL DEFAULT '',
  `dateofbirth` date NOT NULL DEFAULT '0000-00-00',
  `mobileno` varchar(10) NOT NULL DEFAULT '',
  `address` varchar(50) NOT NULL DEFAULT '',
  `emailid` varchar(20) NOT NULL DEFAULT '',

  PRIMARY KEY (`candidateid`),
  KEY `evs_tbl_candidate_fk` (`electionid`),
  KEY `evs_tbl_candidate_fk_1` (`partyid`),
  CONSTRAINT `evs_tbl_candidate_fk_3` FOREIGN KEY (`partyid`) REFERENCES `evs_tbl_party` (`partyid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `evs_tbl_candidate_fk` FOREIGN KEY (`candidateid`) REFERENCES `evs_tbl_result` (`serialno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `evs_tbl_candidate_fk_1` FOREIGN KEY (`candidateid`) REFERENCES `evs_tbl_voter_details` (`serialno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `evs_tbl_candidate_fk_2` FOREIGN KEY (`electionid`) REFERENCES `evs_tbl_election` (`electionid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

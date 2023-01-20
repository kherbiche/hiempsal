#!/bin/bash
red=`tput setaf 1`
green=`tput setaf 2`
oran=`tput setaf 3`
bleu=`tput setaf 4`
pink=`tput setaf 5`
reset=`tput sgr0`
bold=`tput bold`
underline=`tput smul`
dis_underline=`tput rmul`
bel=`tput bel`

echo "${reset} ${green} ${bold} ${underline}                                                                             ${dis_underline} ${reset}"
echo "${reset} ${green} ${bold}      |==================== ${underline} Welcome to the APP ${dis_underline} ====================| ${reset}"
echo "${reset} ${green} ${bold} ${underline}                                                                             ${dis_underline} ${reset}"
echo ""
echo ""

echo "${reset} ${green}++[JAVA_HOME]:  ${reset}"
		$JAVA_HOME
echo "${reset} ${green}++[JAVA]:" 
		java -version ${reset}
echo ""
echo "${reset} ${green} ++[MAVEN_HOME]: ${reset}"
		$M2_HOME
echo "${reset} ${green} ++[MAVEN]:" 
		mvn -version ${reset}
echo ""
echo ""
echo "${reset} ${bleu} ============================================================ ${reset}"
echo "${reset} ${bleu} ============================================================ ${reset}"
echo "${reset} ${green} ${bold}		===  Building the APP ...  === ${reset}"
echo "${reset} ${bleu} ============================================================ ${reset}"
echo "${reset} ${bleu} ============================================================ ${reset}"

mvn -T 4C clean install
echo "${reset} ${bleu} ============================================================ ${reset}"
echo "${reset} ${bleu} ============================================================ ${reset}"

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
echo ""
echo ""
echo "${reset} ${bleu} ============================================================ ${reset}"
echo "${reset} ${bleu} ============================================================ ${reset}"
echo "${reset} ${green} ${bold}		===  Run the APP ...  === ${reset}"
echo "${reset} ${bleu} ============================================================ ${reset}"
echo "${reset} ${bleu} ============================================================ ${reset}"

echo "${reset} ${bleu} ============================================================ ${reset}"
echo "${reset} ${bleu} ============================================================ ${reset}"

java -jar target/usr-0.0.1-RELEASE.jar

echo "${bleu} ============================================================ ${reset}"
echo "${bleu} ============================================================ ${reset}"


#!/bin/sh
echo Hello im the script, here your args $@

gpg2 -e r zhongan35 -o config_E.properties config.properties
#!/bin/bash

if [ $# -eq 1 ]; then
    source $1
else
    source ./dev.conf
fi

PROMPT="[\u@\h]>"

DEST_CMD="mysql --default-character-set=utf8 -h $HOST --user=$USER --password=$PASSWORD --port=$PORT --prompt=$PROMPT $DB"
echo $DEST_CMD

$DEST_CMD

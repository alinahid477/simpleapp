#!/bin/bash

ssh -i /root/.ssh/id_rsa -4 -fNT -L 6443:192.168.220.2:6443 ubuntu@10.79.156.28
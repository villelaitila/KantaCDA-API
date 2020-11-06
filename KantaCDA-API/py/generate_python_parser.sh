export YOUR_PYTHON_INSTALLATION=/home/ville/opt/python-3.9.0

# Needed only once, but no harm anyway
pip3 install generateDS

# Switch directory and generate the parser to py dir
pushd ../Schemas && python3 $YOUR_PYTHON_INSTALLATION/bin/generateDS.py  -o ../py/cda_parser.py CDA_Fi.xsd ; popd

# Fix it if py2k stuff
2to3 -n --no-diffs -j4 -w cda_parser.py


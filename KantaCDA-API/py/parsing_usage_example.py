import norre_cda_parser


filename = 'Diagnoosikooste-esimerkki_20160229.xml'

if os.path.exists(filename):
    root_obj = norre_cda_parser.parse('Diagnoosikooste-esimerkki_20160229.xml', silence=True)
    print(root_obj)
else:
    print('First please download the file, e.g.. wget https://raw.githubusercontent.com/omahoito/rfc/909916e5a57c3d2f4582d0580ac46c9c96b14992/Kanta_examples/Diagnoosikooste-esimerkki_20160229.xml')


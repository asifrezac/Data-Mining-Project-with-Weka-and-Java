#made to sort output by rule number then support 
#change path file as needed 
path = "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/doMaxFPYesClassMax.txtQ3_final_fpMax.txt"

def read_file(path):
    #read the file and return a list of lines
    with open(path, "r") as f:
        textFile = f.readlines()
    doc = []
    for line in textFile:
        doc.append(line.strip().split(" "))
    return doc


def sort_list_len_sup(tuples):
  """Sort list by the list lenght (as in rule size) and then by support"""
  tuples = sorted(tuples, key=len, reverse=True)
  for i in range(len(tuples)):
    for j in range(i+1, len(tuples)):
        #if i list is bigger dont sort by support as it should always be above
      if len(tuples[i]) > len(tuples[j]):
        pass
      else:
        if tuples[i][-1] < tuples[j][-1]:
          tuples[i], tuples[j] = tuples[j], tuples[i]
  return tuples

doc = read_file(path)
doc = sort_list_len_sup(doc)
print(doc)
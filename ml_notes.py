725 DSSM
用户ID，一般会先进行LabelEncoding操作转化为连续整数值
from sklearn.preprocessing import LabelEncoder
https://github.com/datawhalechina/torch-rechub/blob/main/tutorials/Matching.ipynb

保存map
np.save(save_dir+"raw_id_maps.npy", (user_map, item_map))

去重
data[user_cols].drop_duplicates('user_id')
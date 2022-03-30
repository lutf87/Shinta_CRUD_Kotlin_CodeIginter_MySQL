<?php
defined('BASEPATH') OR exit('No direct script access allowed');
class ServerApi extends CI_Controller {

	//tambah
	public function addStaff() {
		$name = $this->input->post('name');
		$hp = $this->input->post('hp');
		$alamat = $this->input->post('alamat');

		$data['staff_name'] = $name;
		$data['staff_hp'] = $hp;
		$data['staff_alamat'] = $alamat;

		$q = $this->db->insert('tb_staff', $data);

		if ($q) {
			$response['pesan'] = 'insert berhasil';
			$response['status'] = 200;
		} else {
			$response['pesan'] = 'insert gagal';
			$response['status'] = 404;
		}
		echo json_encode($response);
	}

	//read
	public function getDataStaff() {
		$q = $this->db->get('tb_staff');
		if ($q->num_rows() > 0) {
			$response['pesan'] = 'data ada';
			$response['status'] = 200;

			$response['staff'] = $q->row();
			$response['staff'] = $q->result();
		} else {
			$response['pesan'] = 'data tidak ada';
			$response['status'] = 404;
		}
		echo json_encode($response);
	}

	//hapus
	public function deleteStaff() {

		$id = $this->input->post('id');
		$this->db->where('staff_id', $id);
		$status = $this->db->delete('tb_staff');
		if ($status == true) {
			$response['pesan'] = 'hapus data berhasil';
			$response['status'] = 200;
		} else {
			$response['pesan'] = 'hapus data gagal';
			$response['status'] = 404;
		}
		echo json_encode($response);
	}

	//update
	public function updateStaff() {
		$id = $this->input->post('id');
		$name = $this->input->post('name');
		$hp = $this->input->post('hp');
		$alamat = $this->input->post('alamat');
		$this->db->where('staff_id', $id);

		$data['staff_name'] = $name;
		$data['staff_hp'] = $hp;
		$data['staff_alamat'] = $alamat;
		$q = $this->db->update('tb_staff', $data);

		if ($q) {
			$response['pesan'] = 'update data berhasil';
			$response['status'] = 200;
		} else {
			$response['pesan'] = 'update data gagal';
			$response['status'] = 404;
		}
		echo json_encode($response);
	}
}
?>
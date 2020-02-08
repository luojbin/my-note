select p.pdt_id, mdc.mdc_id,mdc.mdc_name, mdp.mdp_part_id,part.part_name
	from product as p 	
    join product_module as pdm on p.pdt_id=pdm.pdm_pdt_id 
	join module_catalog as mdc on pdm.pdm_md_id=mdc.mdc_id
    join module_parts as mdp on mdc.mdc_id=mdp.mdp_mdc_id
    join part on mdp.mdp_part_id=part.part_id
where p.pdt_id='856-1';

select * from product;
select * from module_catalog;

select p.pdt_id, mdc.mdc_id,mdc.mdc_name
	from product as p 	
	join product_module as pdm on p.pdt_id=pdm.pdm_pdt_id 
    join module_catalog as mdc on pdm.pdm_md_id=mdc.mdc_id;
